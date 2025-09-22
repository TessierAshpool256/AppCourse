package org.appcource.auth.screen.login.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun LoginTextSignatureView(
    goToRegistration: (() -> Unit),
    goToForgetPass: (() -> Unit),
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Text(
                modifier = Modifier
                    .padding(end = 4.dp),
                text = "Нет аккаунта?",
                color = MaterialTheme.colorScheme.secondary
            )

            Text(
                modifier = Modifier
                    .clickable { goToRegistration() },
                color = MaterialTheme.colorScheme.primary,
                text = "регистрация"
            )
        }
        Text(
            modifier = Modifier
                .clickable { goToForgetPass() },
            color = MaterialTheme.colorScheme.primary,
            text = "Забыл пароль"
        )
    }
}
