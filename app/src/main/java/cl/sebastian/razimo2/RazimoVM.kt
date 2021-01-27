package cl.sebastian.razimo2

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RazimoVM:ViewModel() {


    val repository=RazimoRepository()
    val razimoList=repository.razimoList
    val detailRazimo=repository.detailRazimo
    private val detail=MutableLiveData<Products>()

    init {
        viewModelScope.launch {
            repository.getRazimoFromApi()
        }
    }
    private lateinit var  selectedRazimo:Products

    fun setSelected(product:Products){
        selectedRazimo=product
    }
    fun getDetail():LiveData<Products>{
        return  repository.getProducts(selectedRazimo.id)
    }
}