package com.gustavo.aluvery.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gustavo.aluvery.R
import com.gustavo.aluvery.model.Product
import java.math.BigDecimal

@Composable
fun ProductsSection() {
    Column {
        Text(
            text = "Promoções",
            modifier = Modifier.padding(
                start = 16.dp,
                end = 16.dp,
            ),
            fontSize = 20.sp,
            fontWeight = FontWeight(400)
        )
        Row(
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                //dessa forma, esse padding será aplicado
                // apenas no conteúdo e mantém exatamente
                // o mesmo aspecto visual.
                .padding(horizontal = 16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Spacer(modifier = Modifier)
            ProductItem(
                Product(
                    name = "Hamburguer",
                    price = BigDecimal("12.99"),
                    image = R.drawable.burger
                )
            )
            ProductItem(
                Product(
                    name = "Pizza",
                    price = BigDecimal("19.99"),
                    image = R.drawable.pizza
                )
            )
            ProductItem(
                Product(
                    name = "Batata frita",
                    price = BigDecimal("08.99"),
                    image = R.drawable.fries
                )
            )
            //Spacer(modifier = Modifier)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductsSectionPreview() = ProductsSection()
