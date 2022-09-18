package binar.academy.latihan_chapter4_livedata.fragment

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import binar.academy.latihan_chapter4_livedata.R
import binar.academy.latihan_chapter4_livedata.databinding.FragmentDetailProductBinding
import binar.academy.latihan_chapter4_livedata.model.Product
import com.bumptech.glide.Glide

class DetailProductFragment : Fragment() {
    private var _binding : FragmentDetailProductBinding? = null
    private val binding get() = _binding!!

    private val args : DetailProductFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_product, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val dataProduct = args.dataproduct

        binding.apply {
            productDetail = dataProduct

            context?.let {
                Glide.with(it)
                    .load(dataProduct.gambar)
                    .into(binding.ivProductDetail)
            }

            btnBackDetail.setOnClickListener {
                findNavController().navigateUp()
            }

            btnBuy.setOnClickListener {
                intentWhatsApp(dataProduct)
            }
        }
    }

    private fun intentWhatsApp(data : Product){
        val phoneNumber = "+62 82297972011"
        val urlWhatsapp = "https://api.whatsapp.com/send?phone=%s&text=%s"
        val message = "Halo, Saya tertarik dengan produk ${data.nama} dengan harga Rp.${data.harga}, apakah masih available?"

        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(String.format(urlWhatsapp, phoneNumber, message)))
        startActivity(intent)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}