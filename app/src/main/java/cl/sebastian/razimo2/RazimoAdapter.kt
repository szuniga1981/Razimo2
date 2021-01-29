package cl.sebastian.razimo2

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import cl.sebastian.razimo2.databinding.ItemListBinding
import coil.load
import timber.log.Timber

class RazimoAdapter: RecyclerView.Adapter<RazimoVH>() {

    private var razimoList = listOf<Products>()
    private val selectedProduct = MutableLiveData<Products>()
    fun selectedRazimo(): LiveData<Products> = selectedProduct

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RazimoVH {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context))
        return RazimoVH(binding)
    }

    override fun onBindViewHolder(holder: RazimoVH, position: Int) {
        val products = razimoList[position]
        holder.bind(products)
        holder.itemView.setOnClickListener {
            Timber.d("mostrando DetailFragment")
            selectedProduct.value = products
        }

    }

    override fun getItemCount(): Int {
        return razimoList.size
    }
    fun updateList(lista: List<Products>) {
        razimoList=lista
        notifyDataSetChanged()
    }

}
        class RazimoVH(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(products: Products) {
                binding.tvPrice.text="$".plus(products.price)
                binding.ivList.load("https://www.razimo.cl/wp-content/uploads/2020/07/logo-10-por-100.jpg")
                binding.tvListPrd.text=products.name
               // binding.tvListPrd.text = products.title.rendered
               // binding.tvPrice.text=products._price
                //binding.ivList.load(products.images.src)

            }

        }



