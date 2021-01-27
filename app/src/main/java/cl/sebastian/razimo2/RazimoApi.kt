package cl.sebastian.razimo2


import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.Query

interface RazimoApi {
    @Headers("ConsumerKey:ck_3b1182c7b77bfee4281dfcbe490b755bb30d5515","consumerSecret:cs_9966ae06878b31bc4c01c7bb792d0ef7bf9cd442")

    @GET("products" )

//fun fetchPosts(@Header("Authorization") token: String): Call<PostsResponse>
    suspend fun getProducts(): Response<List<Products>>





}