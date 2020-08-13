package kapadokia.nyandoro.kotlinmvvn.data.network.responses

import kapadokia.nyandoro.kotlinmvvn.data.db.entities.User

// this class will do nothing except storing the json response
data class AuthResponse (
     val isSuccessful: Boolean?,
     val message: String?,
     val user: User?
 )