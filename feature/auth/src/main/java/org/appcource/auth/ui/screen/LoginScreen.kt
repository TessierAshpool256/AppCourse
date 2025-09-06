package org.appcource.auth.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue


private const val LOG_TAG = "login"

@Composable
fun LoginScreen(
    login: String,
//    appBackStack: (() -> AppBackStack<NavKey>)
) {
    var login by remember { mutableStateOf(login) }
    var password by remember { mutableStateOf("") }

    Column {
        Text("LoginScreen")

        TextField(
            value = login,
            onValueChange = { login = it }
        )

        TextField(
            value = password,
            onValueChange = { password = it }
        )

        Button(
            onClick = { Log.d(LOG_TAG, "Push login button") }
        ) {
            Text("Вход")

        }
    }

}
