package com.gustavo.aluvery.ui.uiState

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.gustavo.aluvery.sampledata.sampleProducts

class HomeScreenUiState(searchText: String = "") {

    var text by mutableStateOf(searchText)

    val searchedProduct
        get() = if (text.isNotBlank()) {
            sampleProducts.filter { product ->
                product.name.contains(text, ignoreCase = true) ||
                        product.description?.contains(text, true) ?: true
            }
        } else emptyList()

    fun isShowSections() = text.isBlank()
}