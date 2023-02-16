package com.gustavo.aluvery.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gustavo.aluvery.model.Product
import com.gustavo.aluvery.sampledata.sampleSections
import com.gustavo.aluvery.ui.components.CardProductItem
import com.gustavo.aluvery.ui.components.ProductsSection
import com.gustavo.aluvery.ui.components.SearchTextField
import com.gustavo.aluvery.ui.theme.AluveryTheme
import com.gustavo.aluvery.ui.uiState.HomeScreenUiState

@Composable
fun HomeScreen(
    sections: Map<String, List<Product>>,
    searchText: String = ""
) {
    Column {
        // sempre usar remeber para evitar loop de atualalizacao de estado
        val state = remember { HomeScreenUiState(searchText) }

        SearchTextField(searchText = state.text, onSearchChanger = { state.text = it })

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {

            if (state.isShowSections()) {
                for (section in sections) {
                    val title = section.key
                    val products = section.value
                    item {
                        ProductsSection(
                            title = title,
                            products = products
                        )
                    }
                }
            } else {
                items(state.searchedProduct) { p ->
                    CardProductItem(product = p, Modifier.padding(horizontal = 16.dp))
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(sampleSections)
        }
    }
}

@Preview
@Composable
fun HomeScreenWithSearchTextPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(sections = sampleSections, searchText = "a")
        }
    }
}