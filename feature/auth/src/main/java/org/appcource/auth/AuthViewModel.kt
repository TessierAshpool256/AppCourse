package org.appcource.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.appcource.auth.domain.usecase.LoginUseCase
import org.appcource.auth.domain.usecase.goToMediaUseCase
import org.appcourse.navigation.FakeNavigator
import org.appcourse.navigation.NavContract
import javax.inject.Inject

@HiltViewModel
open class AuthViewModel @Inject constructor(
    private val navigate: NavContract,
    private val loginUC: LoginUseCase? = null,
    private val goToMediaUC: goToMediaUseCase? = null
) : ViewModel() {
    var login = mutableStateOf("")
    var password = mutableStateOf("")
    var isError = mutableStateOf(false)


    suspend fun login() {
        loginUC!!.invoke(login.value, password.value).fold(
            {
                navigate.login(true)
                navigate.navigateToHome()
            },
            {
                isError.value = true
                password.value = ""
            }
        )
    }

    fun goToVkMedia() {
        goToMediaUC?.invoke("https://vk.com")
    }

    fun goToOkMedia() {
        goToMediaUC?.invoke("https://ok.ru")
    }

    fun goToRegistration() {
        navigate.navigateToRegister()
    }
}


class FakeAuthViewModel : AuthViewModel(
    FakeNavigator()
)
