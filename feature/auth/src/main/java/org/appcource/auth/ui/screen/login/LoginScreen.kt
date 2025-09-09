package org.appcource.auth.ui.screen.login

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.input.KeyboardType
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import org.appcource.auth.AuthViewModel


private const val LOG_TAG = "login"

@Composable
fun LoginScreen(
    viewModel: AuthViewModel = hiltViewModel<AuthViewModel>()
) {
    var login    by viewModel.login
    var password by viewModel.password
    var isError by viewModel.isError

    val coroutineScope = rememberCoroutineScope()

    Text(
        "Вход"
    )

    Column {
        Text("LoginScreen")

        val alphanumericRegex = Regex("^[A-Za-z0-9]*$")

        TextField(
            value = login,
            singleLine = true,
            label = { Text("example@gmail.com") },
            onValueChange = { newText ->
                if (alphanumericRegex.matches(newText)) {
                    login = newText
                }
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Ascii
            ),
        )

        TextField(
            value = password,
            isError = isError,
            singleLine = true,
            onValueChange = {
                password = it
                if (isError) isError = false
            }
        )

        Button(
            onClick = {
                Log.d(LOG_TAG, "Push login button")
                coroutineScope.launch {
                    viewModel.login()
                }
            }
        ) {
            Text("Вход")
        }

        Button(
            onClick = {
                Log.d(LOG_TAG, "Push Go to registration button")
                viewModel.goToRegistration()
            }
        ) {
            Text("Регистрация")
        }

//        Box(
//            modifier = Modifier.fillMaxSize(),
//            contentAlignment = Alignment.Center
//        ) {
//            IconButton(
//                modifier = Modifier.clickable { goToMediaUseCase().invoke("example.com") },
//
//            ) {
//                Icon(
//
////                    painter = painterResource(id = R.drawable.ic_baseline_send_24),
//                    contentDescription = null,           // null → иконка декоративна
//                    tint = Color.White,
//                    modifier = Modifier.size(20.dp)
//                )
//            }
//        }
    }

}
