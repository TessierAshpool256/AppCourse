package org.appcourse.navigation

private const val LOG_TAG = "nav_api"


interface NavContract {
    fun navigateToLogin(login: String)
    fun navigateToRegister(login: String)

    fun navigateToHome()
    fun navigateToLikeCourse()
    fun navigateToAccount()

    fun goBack()

    fun login(status: Boolean)
}
