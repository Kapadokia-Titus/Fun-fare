package kapadokia.nyandoro.kotlinmvvn.data.repositories

import kapadokia.nyandoro.kotlinmvvn.data.db.AppDatabase
import kapadokia.nyandoro.kotlinmvvn.data.db.entities.User
import kapadokia.nyandoro.kotlinmvvn.data.network.MyApi
import kapadokia.nyandoro.kotlinmvvn.data.network.SafeApiRequest
import kapadokia.nyandoro.kotlinmvvn.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository(
    private val api: MyApi,
    private val db: AppDatabase
) : SafeApiRequest() {

    suspend fun userLogin(email: String, password: String): AuthResponse {
        return apiRequest { api.userLogin(email, password) }
    }

    suspend fun userSignup(
        name: String,
        email: String,
        password: String
    ) : AuthResponse {
        return apiRequest{ api.userSignup(name, email, password)}
    }

    suspend fun saveUser(user: User) = db.getUserDao().upsert(user)

    fun getUser() = db.getUserDao().getuser()

}