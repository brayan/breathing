package br.com.sailtech.breathing.feature.articles.presentation.viewmodel

import br.com.sailtech.breathing.feature.articles.domain.model.Article

data class ArticleViewState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null,
)
