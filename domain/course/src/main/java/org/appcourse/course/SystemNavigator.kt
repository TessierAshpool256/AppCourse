package org.appcourse.course


interface SystemNavigator {
    fun navigate(action: Action)
}

sealed class Action {
    data class OpenWebPage(val url: String) : Action()
}