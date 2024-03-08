package br.com.sailtech.breathing.feature.articles.presentation.viewmodel

import br.com.sailtech.breathing.feature.articles.domain.model.Article
import br.com.sailtech.breathing.util.presentation.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel : BaseViewModel() {

    private val _articleViewState = MutableStateFlow(ArticleViewState(loading = true))
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
            val articles = fetchArticles()
            _articleViewState.emit(ArticleViewState(articles = articles))
        }
    }

    private suspend fun fetchArticles() = articles

    private val articles = listOf(
        Article(
            title = "10 Tips for Effective Time Management",
            description = "Learn how to manage your time more efficiently with these useful tips.",
            date = "2024-03-08",
            imageUrl = "https://example.com/image1.jpg",
        ),
        Article(
            title = "The Benefits of Regular Exercise",
            description = "Discover the numerous health benefits of incorporating regular exercise into your routine.",
            date = "2024-03-07",
            imageUrl = "https://example.com/image2.jpg",
        ),
        Article(
            title = "Introduction to Machine Learning",
            description = "Explore the basics of machine learning and its applications in various industries.",
            date = "2024-03-06",
            imageUrl = "https://example.com/image3.jpg",
        ),
        Article(
            title = "Healthy Eating Habits for a Balanced Diet",
            description = "Learn how to create a balanced diet with nutritious food choices for optimal health.",
            date = "2024-03-05",
            imageUrl = "https://example.com/image4.jpg",
        ),
        Article(
            title = "Effective Strategies for Stress Management",
            description = "Discover practical techniques to reduce stress and improve your overall well-being.",
            date = "2024-03-04",
            imageUrl = "https://example.com/image5.jpg",
        ),
    )
}
