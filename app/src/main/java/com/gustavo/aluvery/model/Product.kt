package com.gustavo.aluvery.model

import androidx.annotation.DrawableRes
import java.math.BigDecimal

data class Product(
    val name: String,
    val price: BigDecimal,
    @DrawableRes val image: Int
)
