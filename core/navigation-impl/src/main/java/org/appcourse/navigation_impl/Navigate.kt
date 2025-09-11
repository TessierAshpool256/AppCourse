package org.appcourse.navigation_impl

import org.appcourse.navigation.AccountNavApi
import org.appcourse.navigation.FavoriteNavApi
import org.appcourse.navigation.HomeNavApi
import org.appcourse.navigation.NavApi
import org.appcourse.navigation.NavContract


class Navigate(
    val appBackStack : AppBackStack
) : NavContract {
    override fun navigateToLogin() {
        appBackStack.add(LoginNav)
    }

    override fun navigateToRegister() {
        appBackStack.add(RegisterNav)
    }

    override fun navigateToHome() {
        appBackStack.add(HomeNav)
    }

    override fun navigateToLikeCourse() {
        appBackStack.add(FavoriteCourseNav)
    }

    override fun navigateToAccount() {
        appBackStack.add(AccountNav)
    }

    override fun goBack() {
        appBackStack.remove()
    }

    override fun login(status: Boolean) {
        if (status)
            appBackStack.login()
        else
            appBackStack.logout()
    }

    override fun navigate(screen: NavApi) {
        when (screen) {
            is HomeNavApi -> navigateToHome()
            is FavoriteNavApi -> navigateToLikeCourse()
            is AccountNavApi -> navigateToAccount()
        }
    }
}
