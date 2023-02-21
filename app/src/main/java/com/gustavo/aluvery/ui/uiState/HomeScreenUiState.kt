package com.gustavo.aluvery.ui.uiState

import com.gustavo.aluvery.model.Product

data class HomeScreenUiState(
    val sections: Map<String, List<Product>> = emptyMap(),
    val searchedProduct: List<Product> = emptyList(),
    val searchText: String = "",
    val onSearchChanger: (String) -> Unit = {},
) {
    fun isShowSections() = searchText.isBlank()
}