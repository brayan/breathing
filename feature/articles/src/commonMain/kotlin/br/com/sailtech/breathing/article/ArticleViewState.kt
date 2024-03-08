package br.com.sailtech.breathing.article

import br.com.sailtech.breathing.article.domain.model.Article

data class ArticleViewState(
    val articles: List<Article> = listOf(),
    val loading: Boolean = false,
    val error: String? = null,
)
