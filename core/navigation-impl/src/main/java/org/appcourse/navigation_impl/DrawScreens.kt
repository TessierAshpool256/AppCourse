package org.appcourse.navigation_impl

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation3.runtime.NavEntry
import androidx.navigation3.ui.NavDisplay
import org.appcource.auth.ui.screen.LoginScreen
import org.appcource.auth.ui.screen.RegisterScreen
import org.appcourse.course_list.ui.screen.AccountScreen
import org.appcourse.course_list.ui.screen.HomeScreen
import org.appcourse.course_list.ui.screen.LikeScreen
import org.appcourse.course_list.ui.view.DrawScreenFrame


@Composable
fun DrawScreens(
    nav: Navigate,
    modifier: Modifier = Modifier,
) {
    NavDisplay(
        modifier = modifier,
        backStack = nav.appBackStack.backStack,
        onBack = { nav.goBack() },
        entryProvider = { key ->
            when (key) {
                is LoginNav -> NavEntry(key) {
                    LoginScreen(
                        key.login,
                        nav
                    )
                }
                is RegisterNav -> NavEntry(key) {
                    RegisterScreen(key.login)
                }

                //--- Course list ---//
                is AppBackStack.RequiresLogin -> NavEntry(key) {
                    DrawScreenFrame(nav) {
                        when (key) {
                            is HomeNav -> {
                                HomeScreen(nav)
                            }

                            is LikeCourseNav -> {
                                LikeScreen()
                            }

                            is AccountNav -> {
                                AccountScreen()
                            }
                        }
                    }
                }

                else -> {
                    error("Unknown route: $key")
                }
            }
        }
//        entryProvider = entryProvider {
//            //--- Auth ---//
//            entry<LoginNav> { key ->
//                LoginScreen(
//                    key.login,
//                )
//            }
//            entry<RegisterNav> { key ->
//                RegisterScreen(key.login)
//            }
//
//            //--- Course list ---//
//            entry<HomeNav> { key ->
//                HomeScreen(nav)
//            }
//            entry<LikeCourseNav> { key ->
//                LikeScreen()
//            }
//            entry<AccountNav> { key ->
//                AccountScreen()
//            }
//        }
    )
}
