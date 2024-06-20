package br.com.sailtech.kmpnews.feature.articles.data.datasource.remote.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleResponseData(
    val title: String? = null,
    val description: String? = null,
    val publishedAt: String? = null,
    @SerialName("urlToImage")
    val imageUrl: String? = null,
)
