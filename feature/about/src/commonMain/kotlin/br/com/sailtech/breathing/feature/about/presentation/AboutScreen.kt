package br.com.sailtech.breathing.feature.about.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import br.com.sailtech.breathing.feature.about.domain.model.getPlatform

@Composable
fun AboutScreen(
    onUpButtonClick: () -> Unit,
) {
    Column {
        Toolbar(onUpButtonClick)
        ContentView()
    }
}

@Composable
private fun Toolbar(onUpButtonClick: () -> Unit) {
    TopAppBar(
        title = { Text(text = "About Device") },
        navigationIcon = {
            IconButton(onClick = onUpButtonClick) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Up Button",
                )
            }
        }
    )
}

@Composable
private fun ContentView() {
    val deviceInfoItems = makeItems()

    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
    ) {
        items(deviceInfoItems) { row ->
            RowView(title = row.first, subtitle = row.second)
        }
    }
}

private fun makeItems(): List<Pair<String, String>> {
    val platform = getPlatform()
    return listOf(
        "Operating System" to "${platform.osName} ${platform.osVersion}",
        "Device" to platform.deviceModel,
        "Density" to platform.density.toString(),
    )
}

@Composable
private fun RowView(
    title: String,
    subtitle: String,
) {
    Column(
        modifier = Modifier.padding(8.dp)
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.body1,
            color = Color.Gray,
        )
        Text(
            text = subtitle,
            style = MaterialTheme.typography.body2,
        )
        Divider()
    }
}
