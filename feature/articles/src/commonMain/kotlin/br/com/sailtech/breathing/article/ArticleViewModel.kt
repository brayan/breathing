package br.com.sailtech.breathing.article

import br.com.sailtech.breathing.util.presentation.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel : BaseViewModel() {

    private val _articleViewState = MutableStateFlow(ArticleViewState())
    val articleViewState: StateFlow<ArticleViewState>
        get() = _articleViewState

    init {
        onInit()
    }

    fun sendIntent(intent: ArticleViewIntent) {
        when (intent) {
            ArticleViewIntent.Init -> onInit()
        }
    }

    private fun onInit() = runCatching {
        scope.launch {
            delay(500)
            _articleViewState.emit(ArticleViewState())
        }
    }
}
