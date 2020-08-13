package kapadokia.nyandoro.kotlinmvvn.data.repositories

import kapadokia.nyandoro.kotlinmvvn.data.network.MyApi
import kapadokia.nyandoro.kotlinmvvn.data.network.SafeApiRequest
import kapadokia.nyandoro.kotlinmvvn.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository : SafeApiRequest(){

    suspend fun userLogin(email:String, password:String) : AuthResponse{
        return apiRequest { MyApi().userLogin(email, password) }

    }
}