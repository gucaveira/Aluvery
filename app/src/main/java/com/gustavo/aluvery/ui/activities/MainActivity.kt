package com.gustavo.aluvery.ui.activities

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.gustavo.aluvery.sampledata.sampleSections
import com.gustavo.aluvery.ui.screens.HomeScreen
import com.gustavo.aluvery.ui.theme.AluveryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App {
                startActivity(Intent(this, ProductFormActivity::class.java))
            }
        }
    }
}

@Composable
fun App(onFabClick: () -> Unit = {}) {
    AluveryTheme {
        Scaffold(floatingActionButton = { SetFloatingActionButton(onFabClick) }) { paddingValues ->
            Box(modifier = Modifier.padding(paddingValues)) {
                Surface {
                    HomeScreen(sampleSections)
                }
            }
        }
    }
}

@Composable
fun SetFloatingActionButton(onFabClick: () -> Unit = {}) {
    FloatingActionButton(onClick = { onFabClick.invoke() }) {
        Icon(imageVector = Icons.Default.Add, contentDescription = null)
    }
}

@Preview
@Composable
private fun AppPreview() {
    App()
}