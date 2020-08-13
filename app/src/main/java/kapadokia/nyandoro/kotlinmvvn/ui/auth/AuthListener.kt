package kapadokia.nyandoro.kotlinmvvn.ui.auth

import kapadokia.nyandoro.kotlinmvvn.data.db.entities.User

interface AuthListener {

    fun onStarted()
    fun onSuccess(user: User)
    fun onFailure(message:String)
}