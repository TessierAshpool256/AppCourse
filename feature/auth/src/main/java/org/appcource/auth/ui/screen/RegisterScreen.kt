package org.appcource.auth.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun RegisterScreen(login: String) {
    Column {
        Text("TODO", color = Color.Companion.Yellow)
        Spacer(modifier = Modifier.padding(20.dp))
        Text("RegisterScreen")
        Text(login)
    }
}
