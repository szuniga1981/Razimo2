package cl.sebastian.razimo2


import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query
import java.util.concurrent.TimeUnit

interface RazimoApi {


    //Your method
    @GET("products")
    //@Headers("consumer_key=ck_083704d61610a7b8fcc72d69514f2a11aa92f3e9&consumer_secret=cs_d8b52e62611233924a293a7518a8c2d0827407aa")
    //@Headers("Authorization: oauth_consumer_key=\"ck_236f3c0061dd41ec7a96ed31ad6befc204be03e5\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"\",oauth_nonce=\"fKeevTSzz1F\",oauth_version=\"1.0\",oauth_signature=\"1TJ%2BAmHCSeSwRcm0s87o1bsrheE%3D\"")


    suspend fun getProducts(): Response<List<Products>>

}

    /*
  //  @Headers("Authorization: oauth_consumer_key=\"ck_236f3c0061dd41ec7a96ed31ad6befc204be03e5\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"\",oauth_nonce=\"fKeevTSzz1F\",oauth_version=\"1.0\",oauth_signature=\"1TJ%2BAmHCSeSwRcm0s87o1bsrheE%3D\"")

    @GET("products" )

//fun fetchPosts(@Header("Authorization") token: String): Call<PostsResponse>
    suspend fun getProducts(): Response<List<Products>>

*/



