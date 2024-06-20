package br.com.sailtech.kmpnews.feature.articles.data.datasource.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticlesResponseData(
    @SerialName("status")
    val status: String? = null,
    @SerialName("totalResults")
    val totalResults: Int? = null,
    @SerialName("articles")
    val articles: List<ArticleResponseData>? = null,
)
