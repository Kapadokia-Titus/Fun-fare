package kapadokia.nyandoro.kotlinmvvn.ui.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import kapadokia.nyandoro.kotlinmvvn.R
import kapadokia.nyandoro.kotlinmvvn.databinding.ActivityLoginBinding
import kapadokia.nyandoro.kotlinmvvn.util.toast

class LoginActivity : AppCompatActivity(), AuthListener{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding:ActivityLoginBinding = DataBindingUtil.setContentView(this,R.layout.activity_login)
        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)

        binding.viewmodel = viewModel
        viewModel.authListener = this
    }

    override fun onStarted() {
        toast("login Started")
    }

    override fun onSuccess() {
        toast("login Success")
    }

    override fun onFailure(message: String) {
        toast(message)
    }
}