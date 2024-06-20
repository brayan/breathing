import androidx.compose.ui.window.ComposeUIViewController
import br.com.sailtech.kmpnews.feature.about.presentation.AboutScreen

fun MainViewController() = ComposeUIViewController {
    AboutScreen(onUpButtonClick = {  })
}
