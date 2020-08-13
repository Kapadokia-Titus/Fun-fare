package kapadokia.nyandoro.kotlinmvvn.ui.auth

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel : ViewModel() {

    // defining values with type safety
    // this variables will be responsible for getting the email and password from the UI
    var email: String? = null
    var password: String? = null

    // an instance of auth listener
     var authListener:AuthListener? =null

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

        // success
        authListener?.onSuccess()
    }
}