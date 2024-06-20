package br.com.sailtech.kmpnews.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.sailtech.kmpnews.feature.about.presentation.AboutScreen
import br.com.sailtech.kmpnews.feature.articles.presentation.view.ArticlesScreen
import br.com.sailtech.kmpnews.feature.articles.presentation.viewmodel.ArticleViewModel
import br.com.sailtech.kmpnews.navigation.Screens

@Composable
fun AppScaffold(articleViewModel: ArticleViewModel) {
    val navController = rememberNavController()

    Scaffold {
        AppNavHost(
            navHostController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            articleViewModel,
        )
    }
}

@Composable
fun AppNavHost(
    navHostController: NavHostController,
    modifier: Modifier,
    articleViewModel: ArticleViewModel,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screens.ARTICLES.route,
        modifier = modifier,
    ) {
        composable(Screens.ARTICLES.route) {
            ArticlesScreen(
                onAboutButtonClick = { navHostController.navigate(Screens.ABOUT_DEVICE.route) },
                articlesViewModel = articleViewModel
            )
        }
        composable(Screens.ABOUT_DEVICE.route) {
            AboutScreen(
                onUpButtonClick = { navHostController.popBackStack() }
            )
        }
    }
}
