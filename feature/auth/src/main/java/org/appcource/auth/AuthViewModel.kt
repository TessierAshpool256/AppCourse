package org.appcource.auth

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import org.appcource.auth.domain.usecase.LoginUseCase
import org.appcourse.navigation.NavContract
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val navigate: NavContract,
    private val loginUC: LoginUseCase,
) : ViewModel() {
    var login = mutableStateOf("")
    var password = mutableStateOf("")
    var isError = mutableStateOf(false)

    suspend fun login() {
        loginUC.invoke(login.value, password.value).fold(
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

    fun goToRegistration() {
        navigate.navigateToRegister()
    }
}