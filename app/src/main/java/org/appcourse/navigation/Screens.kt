package org.appcourse.navigation

import androidx.navigation3.runtime.NavKey


//@Serializable
data class LoginNav(val login: String = ""): NavKey

//@Serializable
data class RegisterNav(val login: String = ""): NavKey

/**
 * _Главная_
 */
//@Serializable
data object HomeNav: AppNavigation.RequiresLogin, NavKey

//@Serializable
object LikeNav: AppNavigation.RequiresLogin, NavKey

//@Serializable
object AccountNav: AppNavigation.RequiresLogin, NavKey
