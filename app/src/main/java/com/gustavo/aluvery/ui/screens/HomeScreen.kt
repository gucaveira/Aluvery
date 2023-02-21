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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gustavo.aluvery.sampledata.sampleSections
import com.gustavo.aluvery.ui.components.CardProductItem
import com.gustavo.aluvery.ui.components.ProductsSection
import com.gustavo.aluvery.ui.components.SearchTextField
import com.gustavo.aluvery.ui.theme.AluveryTheme
import com.gustavo.aluvery.ui.uiState.HomeScreenUiState
import com.gustavo.aluvery.ui.viewmodels.HomeScreenViewModel

@Composable
fun HomeScreen(state: HomeScreenUiState = HomeScreenUiState()) {
    Column {
        SearchTextField(searchText = state.searchText, onSearchChanger = state.onSearchChanger)

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(bottom = 16.dp)
        ) {

            if (state.isShowSections()) {
                for (section in state.sections) {
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

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel) {
    val state by viewModel.uiState.collectAsState()
    HomeScreen(state = state)
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(HomeScreenUiState(sections = sampleSections))
        }
    }
}

@Preview
@Composable
fun HomeScreenWithSearchTextPreview() {
    AluveryTheme {
        Surface {
            HomeScreen(HomeScreenUiState(sections = sampleSections, searchText = "a"))
        }
    }
}