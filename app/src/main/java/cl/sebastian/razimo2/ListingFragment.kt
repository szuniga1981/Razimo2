package cl.sebastian.razimo2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cl.sebastian.razimo2.databinding.FragmentListingBinding

class ListingFragment :Fragment() {

    private lateinit var binding: FragmentListingBinding
    private val viewModel:RazimoVM by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentListingBinding.inflate(layoutInflater)
        val adapter= RazimoAdapter()
        binding.rvListFragment.layoutManager=LinearLayoutManager(context)
        binding.rvListFragment.adapter=adapter
        viewModel.razimoList.observe(viewLifecycleOwner,{
            it?.let {
                adapter.updateList(it)
            }
        })
        adapter.selectedRazimo().observe(viewLifecycleOwner,{
            viewModel.setSelected(it)
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.main_container,DetailFragment())
                ?.addToBackStack("details")
                ?.commit()
        })
        return binding.root
    }
}