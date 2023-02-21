package com.gustavo.aluvery.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.gustavo.aluvery.dao.ProductDao
import com.gustavo.aluvery.model.Product
import com.gustavo.aluvery.sampledata.sampleCandies
import com.gustavo.aluvery.sampledata.sampleDrinks
import com.gustavo.aluvery.sampledata.sampleProducts
import com.gustavo.aluvery.ui.uiState.HomeScreenUiState

class HomeScreenViewModel : ViewModel() {

    private val dao = ProductDao()

    var uiState: HomeScreenUiState by mutableStateOf(HomeScreenUiState(
        sections = mapOf(
            "Todos produtos" to dao.products(),
            "Promoções" to sampleDrinks + sampleCandies,
            "Doces" to sampleCandies,
            "Bebidas" to sampleDrinks
        ),
        onSearchChanger = {
            uiState = uiState.copy(searchText = it, searchedProduct = searchedProduct(it))
        }

    ))
        private set

    private fun containsInNameOrDescription(text: String) = { product: Product ->
        product.name.contains(text, ignoreCase = true) ||
                product.description?.contains(text, true) ?: false
    }

    private fun searchedProduct(text: String) = if (text.isNotBlank()) {
        sampleProducts.filter(containsInNameOrDescription(text)) +
                dao.products().filter(containsInNameOrDescription(text))
    } else emptyList()
}