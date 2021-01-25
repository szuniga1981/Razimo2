package cl.sebastian.razimo2

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductService {
    /**
     * Get products from web service
     */
    @GET("products")
    fun getProducts(
        @Query("consumer_key") consumer_key: String,
        @Query("consumer_secret") consumer_secret: String,
        @Query("page") page: Int,
        @Query("per_page") itemsPerPage: Int
    ): Call<List<Products>>

}