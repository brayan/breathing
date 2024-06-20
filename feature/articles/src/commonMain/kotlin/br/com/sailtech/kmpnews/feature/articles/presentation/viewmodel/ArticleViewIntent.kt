package br.com.sailtech.kmpnews.feature.articles.presentation.viewmodel

sealed interface ArticleViewIntent {
    data object OnInit : ArticleViewIntent
}
