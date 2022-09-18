package binar.academy.latihan_chapter4_livedata.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import binar.academy.latihan_chapter4_livedata.databinding.ItemProductBinding
import binar.academy.latihan_chapter4_livedata.model.Product
import com.bumptech.glide.Glide

class ProductAdapter(
    private var listProduct : ArrayList<Product>,
    private val onClick : ProductAdapter.ProductInterface)
    : RecyclerView.Adapter<ProductAdapter.ViewHolder>() {

    inner class ViewHolder(private val binding : ItemProductBinding)
        : RecyclerView.ViewHolder(binding.root) {
            fun bind(product: Product){
                binding.product = product

                // maaf gak pake databinding karena mager download gambar :((
                Glide.with(itemView.context)
                    .load(product.gambar)
                    .into(binding.ivProduct)

                itemView.setOnClickListener {
                    onClick.onItemClicked(product)
                }
            }
    }

    interface ProductInterface {
        fun onItemClicked(product: Product)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemProductBinding.inflate(LayoutInflater
            .from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listProduct[position])
    }

    override fun getItemCount() = listProduct.size

    fun setData(data: ArrayList<Product>){
        this.listProduct = data
    }
}