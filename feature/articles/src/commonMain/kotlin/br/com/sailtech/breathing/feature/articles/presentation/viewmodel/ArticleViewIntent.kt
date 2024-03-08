package br.com.sailtech.breathing.feature.articles.presentation.viewmodel

sealed interface ArticleViewIntent {
    data object Init : ArticleViewIntent
}
