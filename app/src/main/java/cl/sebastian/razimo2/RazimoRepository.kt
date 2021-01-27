package cl.sebastian.razimo2

import androidx.lifecycle.LiveData
import timber.log.Timber

class RazimoRepository {

    private val razimoDao=RazimoApplication.razimoDatabase!!.razimoDao()
    val razimoList=razimoDao.getProducts()
    val detailRazimo=razimoDao.getProducts()

    suspend fun getRazimoFromApi(){

        val response = RetrofitClient.retrofitCliente().getProducts()



        when (response.isSuccessful){
            true-> {
                response.body()?.let {
                    razimoDao.insertProducts(it)
                    Timber.d("getSuperHeroFromApi con :${it.size} Razimo")
                }
            }
            false ->
                Timber.d("getSuperHeroFromApi: ${response.errorBody()}")
        }
        }
        fun getProducts(code:Int):LiveData<Products> {
            return  razimoDao.getProductsDetail(code)
        }

    }

