package binar.academy.latihan_chapter4_livedata.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import binar.academy.latihan_chapter4_livedata.model.Product

class ProductViewModel : ViewModel() {

    val data : MutableLiveData<List<Product>> = MutableLiveData()

    private val listProduct = arrayListOf(
        Product(
            "Cabe",
            12000,
            20,
            "https://images.tokopedia.net/img/cache/700/product-1/2020/6/7/8389043/8389043_68f1b346-95f3-497e-b198-79437ca1c8d7_700_700.jpg",
            "Ini cabe"),
        Product(
            "Buku Tulis",
            4000,
            10,
            "https://ceklist.id/wp-content/uploads/2022/03/Buku-Tulis-Terbaik.jpg",
            "Buat nulis"),
        Product(
            "Susu Ultra Milk",
            8000,
            30,
            "https://cf.shopee.co.id/file/c641dfaf7656124b5ac6d3a8f285f87f",
            "Minum susu biar cepet gede"),
        Product(
            "Pulpen",
            12000,
            12,
            "https://s4.bukalapak.com/img/96777466792/s-330-330/5ff36166e0460afd4c2686566f0b7540.jpg.webp",
            "Pulpen isi 10 buah"),
        Product(
            "Daging Sapi",
            70000,
            5,
            "https://asset.kompas.com/crops/loXNzgMXFEX_3avDpy_53_3rXsU=/1x0:1000x666/750x500/data/photo/2021/07/14/60ee601a87545.jpg",
            "Ini daging sapi"),
        Product(
            "Beras",
            81000,
            25,
            "https://www.static-src.com/wcsstore/Indraprastha/images/catalog/full//96/MTA-12483680/sania_sania_beras_premium_2-5_kg_full01_f89ls0cy.jpg",
            "Beras 1 kg")
    )

    fun getProduct(){
        data.value = listProduct
    }
}