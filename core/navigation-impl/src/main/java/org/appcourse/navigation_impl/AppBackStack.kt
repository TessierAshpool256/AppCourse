package org.appcourse.navigation_impl

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.navigation3.runtime.NavKey


class AppBackStack(
    startRoute: NavKey,
    private val loginRoute: NavKey
)  {
    interface RequiresLogin

    private var onLoginSuccessRoute: NavKey? = null

    var isLoggedIn by mutableStateOf(false)
        private set

    val backStack = mutableStateListOf(startRoute)

    fun add(route: NavKey) {
        if (route is RequiresLogin && !isLoggedIn) {
            onLoginSuccessRoute = route
            backStack.add(loginRoute)
        } else {
            backStack.add(route)
        }

        if (route == loginRoute) {
            onLoginSuccessRoute = null
        }
    }

    fun remove() = backStack.removeLastOrNull()

    fun login() {
        isLoggedIn = true
        onLoginSuccessRoute?.let {
            backStack.add(it)
            backStack.remove(loginRoute)
        }
    }

    fun logout() {
        isLoggedIn = false
        backStack.removeAll { it is RequiresLogin }
    }
}

fun appBackStack(): AppBackStack {
    return AppBackStack(
        startRoute = LoginNav,
        loginRoute = LoginNav
    )
}
