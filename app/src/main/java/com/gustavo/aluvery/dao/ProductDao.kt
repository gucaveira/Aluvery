package com.gustavo.aluvery.dao

import com.gustavo.aluvery.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class ProductDao {

    companion object {
        //private val products = mutableStateListOf(*sampleProducts.toTypedArray())
        private val products = MutableStateFlow<List<Product>>(emptyList())
    }

    fun products() = products.asStateFlow()

    fun save(product: Product) {
        products.value = products.value + product
    }
}