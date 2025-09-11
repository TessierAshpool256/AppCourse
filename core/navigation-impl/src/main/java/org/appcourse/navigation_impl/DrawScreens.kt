package org.appcourse.navigation_impl

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import org.appcource.auth.screen.login.LoginScreen
import org.appcource.auth.screen.login.RegisterScreen
import org.appcourse.course_list.ui.screen.AccountScreen
import org.appcourse.course_list.ui.screen.favorite.FavoriteScreen
import org.appcourse.course_list.ui.screen.home.HomeScreen
import org.appcourse.course_list.ui.view.DrawScreenFrame
import org.appcourse.navigation.NavContract


@Composable
fun DrawScreens(
    nav: NavContract,
    modifier: Modifier = Modifier,
) {
    nav as Navigate
    NavDisplay(
        modifier = modifier
            .fillMaxSize(1f),
        backStack = nav.appBackStack.backStack,
        onBack = { nav.goBack() },
        entryProvider = { key ->
            when (key) {
                is LoginNav -> NavEntry(key) { LoginScreen() }
                is RegisterNav -> NavEntry(key) { RegisterScreen() }

                //--- Course list ---//
                is AppBackStack.RequiresLogin -> NavEntry(key) {
                    DrawScreenFrame(nav) {
                        when (key) {
                            is HomeNav -> HomeScreen()
                            is FavoriteCourseNav -> FavoriteScreen()
                            is AccountNav -> AccountScreen()
                        }
                    }
                }

                else -> {
                    error("Unknown route: $key")
                }
            }
        }
    )
}
