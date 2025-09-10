package org.appcourse.navigation

private const val LOG_TAG = "nav_api"


interface NavContract {
    fun navigateToLogin()
    fun navigateToRegister()

    fun navigateToHome()
    fun navigateToLikeCourse()
    fun navigateToAccount()

    fun goBack()

    fun login(status: Boolean)
}
