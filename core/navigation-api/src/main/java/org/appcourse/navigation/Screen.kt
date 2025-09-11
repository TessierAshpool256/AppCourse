package org.appcourse.navigation

sealed interface NavApi

interface HomeNavApi: NavApi
interface FavoriteNavApi: NavApi
interface AccountNavApi: NavApi
