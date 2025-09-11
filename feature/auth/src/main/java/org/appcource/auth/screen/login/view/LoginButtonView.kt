package org.appcource.auth.screen.login.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun LoginButtonView(
    dataIsCorrect: Boolean,
    onClick: (() -> Unit)
) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        colors = ButtonColors(
            contentColor = MaterialTheme.colorScheme.secondary,
            containerColor = MaterialTheme.colorScheme.primary,
            disabledContentColor = Color.Black,
            disabledContainerColor = MaterialTheme.colorScheme.onTertiary
        ),
        enabled = dataIsCorrect,
        onClick = onClick
    ) {
        Text("Вход")
    }
}
