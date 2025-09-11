package org.appcource.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.appcource.auth.usecase.LoginUseCase
import org.appcource.auth.usecase.goToMediaUseCase
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
    var dataIsCorrect = mutableStateOf(false)

    private val emailRegex = Regex(
        "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])\$\n",
        RegexOption.COMMENTS
    )

    fun checkData() {
        dataIsCorrect.value = emailRegex.matches(login.value) && password.value.isNotEmpty()
    }

    suspend fun login() {
        loginUC!!.invoke(login.value, password.value).fold(
            {
                navigate.login(true)
                navigate.navigateToHome()
            },
            {
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

    fun goToForgetPass() {
        navigate.navigateToRegister()
    }
}


class FakeAuthViewModel : AuthViewModel(
    FakeNavigator()
)
