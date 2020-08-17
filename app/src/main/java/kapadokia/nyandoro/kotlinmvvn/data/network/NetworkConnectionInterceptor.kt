package kapadokia.nyandoro.kotlinmvvn.data.network

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.Interceptor
import okhttp3.Response

class NetworkConnectionInterceptor(
    context: Context
) : Interceptor {

    private val applicationContext = context.applicationContext
    override fun intercept(chain: Interceptor.Chain): Response {

    }

    private fun isInternetAvailable() : Boolean{
        val connectivityManager = applicationContext.getSystemService(Context.CONNECTIVITY_SERVICE) as
                ConnectivityManager

        // get the internet status
        connectivityManager.activeNetworkInfo.also {
            return it != null && it.isConnected
        }
    }
}