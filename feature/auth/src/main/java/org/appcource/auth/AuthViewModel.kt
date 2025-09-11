package org.appcource.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
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

    private val _dataIsCorrect = MutableStateFlow(false)
    val dataIsCorrect: StateFlow<Boolean> = _dataIsCorrect


    private val emailRegex = Regex(
        "^((?!\\.)[\\w\\-_.]*[^.])(@\\w+)(\\.\\w+(\\.\\w+)?[^.\\W])\$\n",
        RegexOption.COMMENTS
    )

    fun checkData() {
        viewModelScope.launch {
            _dataIsCorrect.value = emailRegex.matches(login.value) && password.value.isNotEmpty()
        }
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
