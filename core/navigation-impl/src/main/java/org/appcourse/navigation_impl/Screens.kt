package org.appcourse.navigation_impl

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable
import org.appcourse.navigation.AccountNavApi
import org.appcourse.navigation.FavoriteNavApi
import org.appcourse.navigation.HomeNavApi


@Serializable
data object LoginNav: NavKey

@Serializable
data object RegisterNav: NavKey


@Serializable
data object HomeNav: AppBackStack.RequiresLogin, NavKey, HomeNavApi

@Serializable
object FavoriteCourseNav: AppBackStack.RequiresLogin, NavKey, FavoriteNavApi

@Serializable
object AccountNav: AppBackStack.RequiresLogin, NavKey, AccountNavApi
