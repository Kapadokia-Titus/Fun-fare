package kapadokia.nyandoro.kotlinmvvn.data.network.responses

import kapadokia.nyandoro.kotlinmvvn.data.db.entities.User

data class AuthResponse(
    val isSuccessful : Boolean?,
    val message: String?,
    val user: User?
)