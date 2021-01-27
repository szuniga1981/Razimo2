package cl.sebastian.razimo2

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.scribe.builder.ServiceBuilder
import org.scribe.model.OAuthRequest
import org.scribe.model.SignatureType
import org.scribe.model.Verb
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitClient {
    companion object {
        private const val BASE_URL = "https://akabab.github.io/superhero-api/api/"

        fun retrofitCliente(): RazimoApi {
            val retrofit = Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(
                    GsonConverterFactory.create()
            ).build()


            return retrofit.create(RazimoApi::class.java)
        }
    }

}