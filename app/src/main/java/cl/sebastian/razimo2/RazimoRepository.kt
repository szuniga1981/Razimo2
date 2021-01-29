package cl.sebastian.razimo2

import androidx.lifecycle.LiveData
import retrofit2.Retrofit
import timber.log.Timber

class RazimoRepository {

    private val razimoDao=RazimoApplication.razimoDatabase!!.razimoDao()
    val razimoList=razimoDao.getProducts()
    val detailRazimo=razimoDao.getProducts()

    suspend fun getRazimoFromApi(){
            Timber.d("buscandodatos")
        val response = RetrofitClient.retrofitCliente().getProducts()
        Timber.d("buscandodatosdespues")



        when (response.isSuccessful){
            true-> {
                response.body()?.let {
                    razimoDao.insertProducts(it)
                    Timber.d(" getRazimoFromApi con :${it.size} Razimo")
                }
            }
            false ->
                Timber.d(" getRazimofalse: ${response.code()}")
        }
        }
        fun getProducts(code:Int):LiveData<Products> {
            return  razimoDao.getProductsDetail(code)
        }

    }

