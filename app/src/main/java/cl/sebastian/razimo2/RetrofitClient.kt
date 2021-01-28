package cl.sebastian.razimo2

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.stream.DoubleStream.builder
import java.util.stream.IntStream.builder

class RetrofitClient {
    companion object {
        private const val BASE_URL = "https://www.razimo.cl/wp-json/wc/v3/"

    val logging= HttpLoggingInterceptor()


    val httpClient= OkHttpClient.Builder()
        .addInterceptor(logging)
        .build()


    fun retrofitCliente(): RazimoApi {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)

            .addConverterFactory(
                GsonConverterFactory
                    .create()
            )
            .client(httpClient)
            .build()






        return retrofit.create(RazimoApi::class.java)
    }
}
    }