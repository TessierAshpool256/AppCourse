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
import androidx.navigation3.runtime.NavKey
import org.appcourse.navigation.AppBackStack
import org.appcourse.navigation.DrawScreens
import org.appcourse.navigation.LoginNav
import org.appcourse.navigation.Navigate
import org.appcourse.ui.theme.AppCourseTheme
import org.appcourse.utile.setEdgeToEdgeConfig



private data object Home

// A marker interface is used to mark any routes that require login
private data object Login

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
                    val navigate = remember {
                        Navigate(
                            AppBackStack<NavKey>(
                                startRoute = LoginNav("log"),
                                loginRoute = LoginNav()
                            )
                        )
                    }
                    DrawScreens(navigate)
                }
            }
        }
    }
}
