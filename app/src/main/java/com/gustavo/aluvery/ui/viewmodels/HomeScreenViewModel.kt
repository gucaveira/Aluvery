package com.gustavo.aluvery.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gustavo.aluvery.dao.ProductDao
import com.gustavo.aluvery.model.Product
import com.gustavo.aluvery.sampledata.sampleCandies
import com.gustavo.aluvery.sampledata.sampleDrinks
import com.gustavo.aluvery.sampledata.sampleProducts
import com.gustavo.aluvery.ui.uiState.HomeScreenUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel : ViewModel() {

    private val dao = ProductDao()

    private val _uiState = MutableStateFlow(HomeScreenUiState())
    val uiState get() = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(onSearchChanger = {

                _uiState.value = _uiState.value.copy(
                    searchText = it,
                    searchedProduct = searchedProduct(it)
                )
            })
        }


        viewModelScope.launch {
            dao.products().collect { products ->
                _uiState.value = _uiState.value.copy(
                    sections = mapOf(
                        "Todos produtos" to products,
                        "Promoções" to sampleDrinks + sampleCandies,
                        "Doces" to sampleCandies,
                        "Bebidas" to sampleDrinks
                    ),
                    searchedProduct = searchedProduct(_uiState.value.searchText)
                )
            }
        }
    }

    private fun containsInNameOrDescription(text: String) = { product: Product ->
        product.name.contains(text, ignoreCase = true) ||
                product.description?.contains(text, true) ?: false
    }

    private fun searchedProduct(text: String) = if (text.isNotBlank()) {
        sampleProducts.filter(containsInNameOrDescription(text)) +
                dao.products().value.filter(containsInNameOrDescription(text))
    } else emptyList()
}