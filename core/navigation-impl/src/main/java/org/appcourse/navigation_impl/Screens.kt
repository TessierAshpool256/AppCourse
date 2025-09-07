package org.appcourse.navigation_impl

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable


@Serializable
data class LoginNav(val login: String = ""): NavKey

@Serializable
data class RegisterNav(val login: String = ""): NavKey

/**
 * _Главная_
 */
@Serializable
data object HomeNav: AppBackStack.RequiresLogin, NavKey

@Serializable
object LikeCourseNav: AppBackStack.RequiresLogin, NavKey

@Serializable
object AccountNav: AppBackStack.RequiresLogin, NavKey
