package org.appcourse.ui_theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
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
//    val colorScheme = when {
//        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
//            val context = LocalContext.current
//            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
//        }
//
//        darkTheme -> DarkColorScheme
//        else -> LightColorScheme
//    }


    val myShapes = Shapes(
        extraSmall = RoundedCornerShape(2.dp),   // например, для чек‑боксов
        small = RoundedCornerShape(6.dp),   // для небольших кнопок
        medium = RoundedCornerShape(12.dp),  // основной вариант
        large = RoundedCornerShape(20.dp),  // карточки, диалоги
        extraLarge = RoundedCornerShape(30.dp)   // модальные окна, FAB‑ы
    )


    MaterialTheme(
        colorScheme = DarkColorScheme,
        typography = Typography,
        shapes      = myShapes,
        content = content
    )
}