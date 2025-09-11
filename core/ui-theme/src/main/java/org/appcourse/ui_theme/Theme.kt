package org.appcourse.ui_theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

private val DarkColorScheme = darkColorScheme(
    primary = Green,
    secondary = White,
    tertiary = DarkGray,
    onTertiary = LightGray,
    background = Dark
)


@Composable
fun AppCourseTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val myShapes = Shapes(
        extraSmall = RoundedCornerShape(2.dp),
        small = RoundedCornerShape(6.dp),
        medium = RoundedCornerShape(16.dp),
        large = RoundedCornerShape(20.dp),
        extraLarge = RoundedCornerShape(30.dp)
    )

    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        shapes      = myShapes,
        content = content
    )
}
