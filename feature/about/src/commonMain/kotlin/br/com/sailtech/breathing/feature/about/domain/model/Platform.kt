package br.com.sailtech.breathing.feature.about.domain.model

interface Platform {
    val osName: String
    val osVersion: String
    val deviceModel: String
    val density: Int

    fun logSystemInfo()
}

// expects this implementation to be on both platforms
expect fun getPlatform(): Platform
