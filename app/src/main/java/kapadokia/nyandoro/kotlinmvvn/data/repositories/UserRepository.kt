package kapadokia.nyandoro.kotlinmvvn.data.repositories

import kapadokia.nyandoro.kotlinmvvn.data.network.MyApi
import kapadokia.nyandoro.kotlinmvvn.data.network.responses.AuthResponse
import retrofit2.Response

class UserRepository {

    suspend fun userLogin(email:String, password:String) : Response<AuthResponse>{
       return MyApi().userLogin(email,password)
    }
}