package br.com.sailtech.breathing.feature.about.domain.model

import android.content.res.Resources
import android.os.Build
import android.util.Log
import kotlin.math.round

private class AndroidPlatform : Platform {
    override val osName = "Android"
    override val osVersion = Build.VERSION.SDK_INT.toString()
    override val deviceModel = "${Build.MANUFACTURER} ${Build.MODEL}"
    override val density = round(Resources.getSystem().displayMetrics.density).toInt()

    override fun logSystemInfo() {
        Log.d("Breathing App", "$osName, $osVersion, $deviceModel, $density")
    }
}

// actual implementation of getPlatform() on Android
actual fun getPlatform(): Platform = AndroidPlatform()