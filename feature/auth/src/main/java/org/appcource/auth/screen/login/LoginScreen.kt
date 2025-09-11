package org.appcource.auth.screen.login

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import org.appcource.auth.AuthViewModel
import org.appcource.auth.FakeAuthViewModel
import org.appcource.auth.screen.login.view.LoginButtonView
import org.appcource.auth.screen.login.view.LoginInputField
import org.appcource.auth.screen.login.view.LoginTextSignatureView
import org.appcource.auth.screen.login.view.LoginTitleView
import org.appcource.auth.screen.login.view.MediaButtonView
import org.appcource.auth.screen.login.view.PasswordInputField
import org.appcourse.ui_theme.AppCourseTheme


internal const val LOG_TAG = "login"

@Composable
fun LoginScreen(
    viewModel: AuthViewModel = hiltViewModel<AuthViewModel>()
) {
    val alphanumericRegex = remember { Regex("""^[A-Za-z0-9@_.]*$""") }

    val coroutineScope = rememberCoroutineScope()

    var login by viewModel.login
    var password by viewModel.password
    val dataIsCorrect by viewModel.dataIsCorrect.collectAsState()

    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .padding(bottom = 16.dp),
        ) {
            Column(
                horizontalAlignment = Alignment.Start
            ) {
                LoginTitleView()

                Spacer(modifier = Modifier.padding(vertical = 8.dp))

                LoginInputField(
                    label = "Email",
                    exampleText = "example@gmail.com",
                    login = login,
                ) { newText ->
                    if (alphanumericRegex.matches(newText)) {
                        login = newText
                        viewModel.checkData()
                    }
                }

                Spacer(modifier = Modifier.padding(top = 16.dp))

                PasswordInputField(
                    label = "Пароль",
                    exampleText = "Введите пароль",
                    password = password,
                ) { newText ->
                    password = newText
                    viewModel.checkData()
                }

                Spacer(modifier = Modifier.padding(top = 16.dp))

                LoginButtonView(
                    dataIsCorrect
                ) {
                    Log.d(LOG_TAG, "Push login button")
                    coroutineScope.launch {
                        viewModel.login()
                    }
                }

                LoginTextSignatureView(
                    goToForgetPass = viewModel::goToForgetPass,
                    goToRegistration = viewModel::goToRegistration
                )

                Spacer(modifier = Modifier.padding(top = 32.dp))

                HorizontalDivider(
                    color = MaterialTheme.colorScheme.tertiary
                )

                Spacer(modifier = Modifier.padding(top = 24.dp))

                MediaButtonView(
                    goToVkMedia = viewModel::goToVkMedia,
                    goToOkMedia = viewModel::goToVkMedia
                )
            }
        }
    }
}


@SuppressLint("ViewModelConstructorInComposable")
@Preview(showBackground = true,
    device = "id:pixel_9"
)
@Composable
fun LoginScreenPreview() {
    AppCourseTheme {
        LoginScreen(viewModel = FakeAuthViewModel())
    }
}
