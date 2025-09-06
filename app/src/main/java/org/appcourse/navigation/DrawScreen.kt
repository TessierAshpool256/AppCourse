package org.appcourse.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavKey
import androidx.navigation3.runtime.entry
import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.ui.NavDisplay
import org.appcource.auth.ui.screen.LoginScreen
import org.appcourse.screen.AccountScreen
import org.appcourse.screen.HomeScreen
import org.appcourse.screen.LikeScreen


@Composable
internal fun DrawScreen(
    appBackStack: AppNavigation<NavKey>,
    modifier: Modifier = Modifier,
) {
    NavDisplay(
        modifier = modifier,
        backStack = appBackStack.backStack,
        onBack = { appBackStack.remove() },
        entryProvider = entryProvider {
            entry<LoginNav> { key ->
                LoginScreen(
                    key.login,
                )
            }
            entry<HomeNav> { key ->
                HomeScreen() { appBackStack }
            }
            entry<LikeNav> { key ->
                LikeScreen()
            }
            entry<AccountNav> { key ->
                AccountScreen()
            }
        }
    )
}
