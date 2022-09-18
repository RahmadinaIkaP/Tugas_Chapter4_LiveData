package binar.academy.latihan_chapter4_livedata.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import binar.academy.latihan_chapter4_livedata.R
import binar.academy.latihan_chapter4_livedata.adapter.ProductAdapter
import binar.academy.latihan_chapter4_livedata.databinding.FragmentHomeBinding
import binar.academy.latihan_chapter4_livedata.model.Product
import binar.academy.latihan_chapter4_livedata.viewmodel.ProductViewModel

class HomeFragment : Fragment(), ProductAdapter.ProductInterface {
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter : ProductAdapter
    private val viewModel : ProductViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setDataRv()

    }

    fun setDataRv(){
        adapter = ProductAdapter(ArrayList(), this)

        viewModel.getProduct()
        viewModel.data.observe(viewLifecycleOwner){
            adapter.setData(it as ArrayList<Product>)
        }

        binding.rvProduct.adapter = adapter
        binding.rvProduct.layoutManager = GridLayoutManager(context, 2)
    }

    override fun onItemClicked(product: Product) {
        val action = HomeFragmentDirections.actionHomeFragmentToDetailProductFragment(product)
        findNavController().navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}