package br.com.sailtech.breathing.feature.articles.presentation.viewmodel

import br.com.sailtech.breathing.feature.articles.domain.model.Article

sealed class ArticleViewState {
    data object Loading : ArticleViewState()

    data class Success(
        val articles: List<Article> = listOf(),
    ) : ArticleViewState()

    data class Error(
        val message: String,
    ) : ArticleViewState()
}
