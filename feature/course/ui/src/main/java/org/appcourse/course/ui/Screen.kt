package org.appcourse.course.ui

import org.appcourse.course_list.R
import org.appcourse.navigation.AccountNavApi
import org.appcourse.navigation.FavoriteNavApi
import org.appcourse.navigation.HomeNavApi


sealed class Screen(val title: String, val iconId: Int) {
    object Home: Screen("Главная", R.drawable.ic_house), HomeNavApi
    object Favorite: Screen("Избранное", R.drawable.ic_bookmark), FavoriteNavApi
    object Account: Screen("Аккаунт", R.drawable.ic_person), AccountNavApi
}
