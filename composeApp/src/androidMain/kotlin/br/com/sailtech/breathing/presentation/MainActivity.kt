package br.com.sailtech.breathing.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import br.com.sailtech.breathing.feature.about.presentation.AboutScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AboutScreen()
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    AboutScreen()
}