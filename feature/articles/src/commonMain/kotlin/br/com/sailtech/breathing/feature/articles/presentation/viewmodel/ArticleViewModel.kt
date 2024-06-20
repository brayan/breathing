package br.com.sailtech.breathing.feature.articles.presentation.viewmodel

import br.com.sailtech.breathing.feature.articles.domain.model.Article
import br.com.sailtech.breathing.util.presentation.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ArticleViewModel : BaseViewModel() {

    private val _articleViewState = MutableStateFlow<ArticleViewState>(ArticleViewState.Loading)
    val articleViewState: StateFlow<ArticleViewState>
        get() = _articleViewState

    init {
        onInit()
    }

    fun sendIntent(intent: ArticleViewIntent) {
        when (intent) {
            ArticleViewIntent.OnInit -> onInit()
        }
    }

    private fun onInit() = runCatching {
        scope.launch {
            delay(1500)
            _articleViewState.emit(ArticleViewState.Error(message = "Something went wrong"))

            delay(1500)
            val articles = fetchArticles()
            _articleViewState.emit(ArticleViewState.Success(articles = articles))
        }
    }

    private suspend fun fetchArticles() = articles

    private val articles = listOf(
        Article(
            title = "10 Tips for Effective Time Management",
            description = "Learn how to manage your time more efficiently with these useful tips.",
            date = "2024-03-08",
            imageUrl = "https://images.unsplash.com/photo-1495364141860-b0d03eccd065?q=80&w=1476&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        ),
        Article(
            title = "The Benefits of Regular Exercise",
            description = "Discover the numerous health benefits of incorporating regular exercise into your routine.",
            date = "2024-03-07",
            imageUrl = "https://images.unsplash.com/photo-1607962837359-5e7e89f86776?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        ),
        Article(
            title = "Introduction to Machine Learning",
            description = "Explore the basics of machine learning and its applications in various industries.",
            date = "2024-03-06",
            imageUrl = "https://images.unsplash.com/photo-1511376777868-611b54f68947?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        ),
        Article(
            title = "Healthy Eating Habits for a Balanced Diet",
            description = "Learn how to create a balanced diet with nutritious food choices for optimal health.",
            date = "2024-03-05",
            imageUrl = "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        ),
        Article(
            title = "Effective Strategies for Stress Management",
            description = "Discover practical techniques to reduce stress and improve your overall well-being.",
            date = "2024-03-04",
            imageUrl = "https://plus.unsplash.com/premium_photo-1702598860883-7f3bc393dab7?q=80&w=1470&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D",
        ),
    )
}
