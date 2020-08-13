package kapadokia.nyandoro.kotlinmvvn.ui.auth

interface AuthListener {

    fun onStarted()
    fun onSuccess()
    fun onFailure(message:String)
}