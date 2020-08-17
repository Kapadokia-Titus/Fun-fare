package kapadokia.nyandoro.kotlinmvvn.ui.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kapadokia.nyandoro.kotlinmvvn.R
import kapadokia.nyandoro.kotlinmvvn.data.db.AppDatabase
import kapadokia.nyandoro.kotlinmvvn.data.db.entities.User
import kapadokia.nyandoro.kotlinmvvn.data.network.MyApi
import kapadokia.nyandoro.kotlinmvvn.data.network.NetworkConnectionInterceptor
import kapadokia.nyandoro.kotlinmvvn.data.repositories.UserRepository
import kapadokia.nyandoro.kotlinmvvn.databinding.ActivityLoginBinding
import kapadokia.nyandoro.kotlinmvvn.ui.home.HomeActivity
import kapadokia.nyandoro.kotlinmvvn.util.hide
import kapadokia.nyandoro.kotlinmvvn.util.show
import kapadokia.nyandoro.kotlinmvvn.util.snackbar
import kapadokia.nyandoro.kotlinmvvn.util.toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), AuthListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val networkConnectionInterceptor = NetworkConnectionInterceptor(this)
        val api = MyApi(networkConnectionInterceptor)
        val db = AppDatabase(this)
        val repository = UserRepository(api, db)

        val factory = AuthViewModelFactory(repository)

        val binding:ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProvider(this, factory).get(AuthViewModel::class.java)

        binding.viewmodel = viewModel
        viewModel.authListener = this
        viewModel.getLoggedInUser().observe(this, Observer {user ->
            if (user !=null){
                // the user is logged in.
                Intent(this, HomeActivity::class.java).also {
                    it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(it)
                }
            }
        })
    }

    override fun onStarted() {
       progress_bar.show()
    }

    override fun onSuccess(user: User) {
        progress_bar.hide()
    }

    override fun onFailure(message: String) {
        progress_bar.hide()
        root_layout.snackbar(message)
    }
}