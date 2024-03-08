package br.com.sailtech.breathing.article

sealed interface ArticleViewIntent {
    data object Init : ArticleViewIntent
}
