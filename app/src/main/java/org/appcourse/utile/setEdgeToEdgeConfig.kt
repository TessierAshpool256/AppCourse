package org.appcourse.utile

import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge

private val darkScrim = android.graphics.Color.argb(0x80, 0x1b, 0x1b, 0x1b)

fun ComponentActivity.setEdgeToEdgeConfig() {
    enableEdgeToEdge(
        statusBarStyle = SystemBarStyle.auto(
            lightScrim = android.graphics.Color.TRANSPARENT,
            darkScrim = android.graphics.Color.TRANSPARENT,
        ) { true },
        navigationBarStyle = SystemBarStyle.auto(
            lightScrim = darkScrim,
            darkScrim = darkScrim,
        ) { true },
    )

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        window.isNavigationBarContrastEnforced = false
    }
}
