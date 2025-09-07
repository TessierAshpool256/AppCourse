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
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import dagger.hilt.android.AndroidEntryPoint
import org.appcourse.di.AppComponent
import org.appcourse.di.DaggerAppComponent
import org.appcourse.navigation_impl.DrawScreens
import org.appcourse.navigation_impl.Navigate
import org.appcourse.navigation_impl.appBackStack
import org.appcourse.ui.theme.AppCourseTheme
import org.appcourse.utile.setEdgeToEdgeConfig


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
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

                    val navigate = remember { Navigate(appBackStack()) }
                    val appComponent: AppComponent = DaggerAppComponent.factory().create(navigate)

                    DrawScreens(navigate)
                }
            }
        }
    }
}
