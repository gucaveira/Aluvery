package com.gustavo.aluvery.ui.components.desafio

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gustavo.aluvery.R
import com.gustavo.aluvery.ui.theme.AluveryTheme
import com.gustavo.aluvery.ui.theme.Indigo400
import com.gustavo.aluvery.ui.theme.Indigo500

class DesafioCompose : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProductItemDesafio()
        }
    }
}

@Preview(showBackground = true, uiMode = UI_MODE_NIGHT_YES)
@Composable
fun ProductItemDesafio() {
    AluveryTheme {
        Surface(
            modifier = Modifier.padding(8.dp),
            shape = RoundedCornerShape(8.dp),
            elevation = 4.dp
        ) {
            Row(
                modifier = Modifier
                    .height(height = 200.dp)
                    .fillMaxWidth()
            ) {
                val imageSize = 100.dp

                Box(
                    modifier = Modifier
                        .fillMaxHeight()
                        .width(imageSize)
                        .background(
                            brush = Brush.verticalGradient(colors = listOf(Indigo400, Indigo500))
                        )
                ) {

                    Image(
                        painter = painterResource(id = R.drawable.placeholder),
                        contentDescription = null,
                        Modifier
                            .size(imageSize)
                            .align(Alignment.Center)
                            .offset(x = imageSize / 2)
                            .clip(shape = CircleShape)
                            .border(
                                BorderStroke(
                                    2.dp,
                                    brush = Brush.verticalGradient(listOf(Indigo400, Indigo500))
                                ),
                                CircleShape
                            )
                    )
                }
                Spacer(modifier = Modifier.width(imageSize / 2))
                Box(
                    modifier = Modifier
                        .padding(16.dp)
                        .fillMaxHeight()
                        .padding(16.dp)
                        .align(CenterVertically)
                ){
                    Column {
                        Text(text = LoremIpsum(50).values.first(),
                        overflow = TextOverflow.Ellipsis,
                        lineHeight = 20.sp)
                    }
                }
            }
        }
    }
}