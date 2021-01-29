package cl.sebastian.razimo2

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    companion object {
        private const val BASE_URL = "https://www.razimo.cl/index.php/wp-json/public-woo/v1/"
        //https://local.wordpress.dev/wp-json/wc/v2/orders?

        fun retrofitCliente(): RazimoApi {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                GsonConverterFactory.create()
            ).build()

            return retrofit.create(RazimoApi::class.java)
        }
    }

}