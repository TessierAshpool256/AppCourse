package org.appcourse.utile

import android.os.Build
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge


fun ComponentActivity.setEdgeToEdgeConfig() {
    enableEdgeToEdge()
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
        window.isNavigationBarContrastEnforced = false
    }
}
