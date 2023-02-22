package com.gustavo.aluvery.ui.uiState

data class ProductFormUiState(
    var url: String = "",
    var name: String = "",
    var price: String = "",
    var description: String = "",
    var onUrlChange: (String) -> Unit = {},
    var onNameChange: (String) -> Unit = {},
    val onDescriptionChange: (String) -> Unit = {},
    val onPriceChange: (String) -> Unit = {},
) {
    val isShowPreview: Boolean get() = url.isNotBlank()

}
