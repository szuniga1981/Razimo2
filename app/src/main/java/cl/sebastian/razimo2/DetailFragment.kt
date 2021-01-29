package cl.sebastian.razimo2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import cl.sebastian.razimo2.databinding.FragmentDetailBinding
import coil.load

class DetailFragment :Fragment() {
    lateinit var binding: FragmentDetailBinding
    private val viewModel:RazimoVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentDetailBinding.inflate(layoutInflater)
        viewModel.getDetail().observe(viewLifecycleOwner,{
            it?.let {
                binding.tvPrecio.text="$".plus(it.price)
                binding.tvNombreDetail.text=it.name
                binding.tvDespripcion.text=it.description
               // binding.tvPrecio.text=it.price
                //binding.tvProductoDetail.text=it.description
                binding.ivDetail.load("https://www.razimo.cl/wp-content/uploads/2020/07/logo-10-por-100.jpg")
            }
        })
        return binding.root
    }
}