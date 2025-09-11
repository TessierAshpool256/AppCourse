package org.appcourse

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity

@Composable
fun calculateGradientHeight(): () -> Float {
    val statusBars = WindowInsets.Companion.statusBars
    val density = LocalDensity.current
    return { statusBars.getTop(density).times(1.2f) }
}


@Composable
fun StatusBarProtection(
    color: Color = MaterialTheme.colorScheme.background,
    heightProvider: () -> Float = calculateGradientHeight(),
) {
    Canvas(Modifier.fillMaxSize()) {
        drawRect(
            color = color,
            size = Size(size.width, heightProvider()),
        )
    }
}
