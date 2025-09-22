package org.appcourse


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import org.appcourse.navigation.NavContract
import org.appcourse.navigation_impl.DrawScreens
import org.appcourse.ui_theme.AppCourseTheme
import org.appcourse.utile.setEdgeToEdgeConfig
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var lazyNav: dagger.Lazy<NavContract>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setEdgeToEdgeConfig()
        setContent {
            val insets = WindowInsets.systemBars
                .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
            AppCourseTheme {
                Box(
                    modifier = Modifier.padding(insets.asPaddingValues())
                ) {
                    DrawScreens(lazyNav.get())
                }
                StatusBarProtection()
            }
        }
    }
}
