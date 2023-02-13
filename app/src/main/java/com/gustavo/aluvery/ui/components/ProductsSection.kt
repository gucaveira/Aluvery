package com.gustavo.aluvery.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gustavo.aluvery.model.Product
import com.gustavo.aluvery.sampledata.sampleProducts
import com.gustavo.aluvery.ui.theme.AluveryTheme

@Composable
fun ProductsSection(
    title: String,
    products: List<Product>
) {
    Column {
        Text(
            text = title,
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
            ),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        LazyRow(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            // add padding apenas no conteudo
            contentPadding = PaddingValues(horizontal = 16.dp)
        ) {
            items(products) { p ->
                ProductItem(product = p)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsSectionPreview() {
    AluveryTheme {
        Surface {
            ProductsSection("Promoções", products = sampleProducts)
        }
    }
}