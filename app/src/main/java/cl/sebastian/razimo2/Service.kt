package cl.sebastian.razimo2

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val TAG = "ApiService"

/*
this function query web service for data via retrofit library
if data retrieve successful i.e the [response.isSuccessful], meaning that data is retrieve success
else [onFailure] will handle the error
 */
fun getProductsResult(
    service: ProductService,
    customer_key: String,
    customer_secret: String,
    page: Int,
    itemsPerPage: Int,
    onSuccess: (products: List<Products>) -> Unit,
    onError: (error: String) -> Unit
) {


    service.getProducts(customer_key, customer_secret, page, itemsPerPage).enqueue(
        object : Callback<List<Products>> {
            override fun onFailure(call: Call<List<Products>>?, t: Throwable) {
                Log.d(TAG, "Error ${t.message}")
                onError(t.message ?: "unknown error")
            }

            override fun onResponse(
                call: Call<List<Products>>?,
                response: Response<List<Products>>
            ) {
                Log.d(TAG, "got a response $response")
                if (response.isSuccessful) {
                    val products: List<Products> = response.body()!!
                    onSuccess(products)
                } else {
                    onError(response.errorBody()?.string() ?: "Unknown error")
                }
            }
        }
    )
}