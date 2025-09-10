package org.appcource.auth.ui.screen.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import org.appcource.auth.AuthViewModel


@Composable
fun RegisterScreen(
    viewModel: AuthViewModel = hiltViewModel<AuthViewModel>()
) {
    Column {
        Text("TODO", color = Color.Companion.Yellow)
        Spacer(modifier = Modifier.padding(20.dp))
        Text("RegisterScreen")
        Text(viewModel.login.value)
    }
}
