package br.com.sailtech.kmpnews.util.presentation

import kotlinx.coroutines.CoroutineScope

expect open class BaseViewModel() {
    val scope: CoroutineScope
}