package org.appcourse.navigation


class FakeNavigator : NavContract {
    override fun navigateToLogin() { Unit}
    override fun navigateToRegister() { Unit}
    override fun navigateToHome() { Unit}
    override fun navigateToLikeCourse() { Unit}
    override fun navigateToAccount() { Unit}
    override fun goBack() { Unit}
    override fun login(status: Boolean) { Unit}
}
