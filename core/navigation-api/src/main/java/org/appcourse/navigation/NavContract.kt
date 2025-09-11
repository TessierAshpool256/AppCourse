package org.appcourse.navigation


interface NavContract {
    fun navigateToLogin()
    fun navigateToRegister()

    fun navigateToHome()
    fun navigateToLikeCourse()
    fun navigateToAccount()

    fun goBack()

    fun login(status: Boolean)

    fun navigate(screen: NavApi)
}
