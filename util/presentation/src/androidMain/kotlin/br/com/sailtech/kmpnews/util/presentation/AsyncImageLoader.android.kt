package br.com.sailtech.kmpnews.util.presentation

import androidx.compose.runtime.Composable
import coil.compose.AsyncImage

@Composable
actual fun AsyncImageLoader(model: Any?) {
    AsyncImage(
        model = model,
        contentDescription = null,
    )
}
