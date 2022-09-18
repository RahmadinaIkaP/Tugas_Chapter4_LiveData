package binar.academy.latihan_chapter4_livedata.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(
    val nama : String,
    val harga : Long,
    val stok : Int,
    val gambar : String,
    val deskripsi : String
) : Parcelable
