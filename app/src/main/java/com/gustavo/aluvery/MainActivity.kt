package com.gustavo.aluvery

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gustavo.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AluveryTheme {
                Surface {
                    MyFirstComposable()
                }
            }
        }
    }
}

// a orde do Modifier importa
@Preview(showBackground = true)
@Composable
fun CustomLayoutPreview() {
    Column(
        Modifier
            .padding(all = 8.dp)
            .background(color = Color.Blue)
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        Text(text = "text 1")
        Text(text = "text 2")

        Row(
            Modifier
                .padding(all = 8.dp)
                .background(color = Color.Green)
                .fillMaxHeight(0.1f)
        ) {
            Text(text = "text 3")
            Text(text = "text 4")
        }

        Box(
            Modifier
                .padding(all = 8.dp)
                .background(color = Color.Red)
        ) {
            Row(
                Modifier
                    .padding(all = 8.dp)
                    .background(color = Color.Cyan)
            ) {
                Text(text = "text 5")
                Text(text = "text 6")
            }

            Column(
                Modifier
                    .padding(all = 8.dp)
                    .background(color = Color.Yellow)
            ) {
                Text(text = "Texto 7")
                Text(text = "Texto 8")
            }
        }
    }
}

@Composable
fun MyFirstComposable() {
    Text(text = "My first composable")
}

@Preview(
    showSystemUi = true,
    uiMode = UI_MODE_NIGHT_YES
)
@Preview(
    name = "TextPreview",
    heightDp = 200,
    widthDp = 300,
    showBackground = true
)

@Composable
fun MyFirstComposablePreview() {
    AluveryTheme {
        Surface {
            MyFirstComposable()
        }
    }
}