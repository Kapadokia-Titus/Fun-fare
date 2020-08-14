package kapadokia.nyandoro.kotlinmvvn.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel
import kapadokia.nyandoro.kotlinmvvn.data.repositories.UserRepository
import kapadokia.nyandoro.kotlinmvvn.util.ApiException
import kapadokia.nyandoro.kotlinmvvn.util.Coroutines

class AuthViewModel (
   private val repository: UserRepository
) : ViewModel() {

    // defining values with type safety
    // this variables will be responsible for getting the email and password from the UI
    var email: String? = null
    var password: String? = null

    // an instance of auth listener
     var authListener:AuthListener? =null

    // to observe user changes in the local database
    fun getLoggedInUser() = repository.getUser()


    // function for handling login button click
    fun onLoginButtonClicked( view: View){

        authListener?.onStarted()
        // checking if email or password is empty
        if (email.isNullOrEmpty() || password.isNullOrEmpty()){

            // display error message
            authListener?.onFailure("Invalid email or password")


            // stop further execution
            return
        }

        Coroutines.main {
            try {
                val authResponse = repository.userLogin(email!!, password!!)
                authResponse.user?.let {
                    authListener?.onSuccess(it)
                    repository.saveUser(it)
                    return@main
                }

                authListener?.onFailure(authResponse.message!!)
            }catch (e: ApiException){
                authListener?.onFailure(e.message!!)
            }

        }

    }
}