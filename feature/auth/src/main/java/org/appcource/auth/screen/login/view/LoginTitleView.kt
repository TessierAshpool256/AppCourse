package org.appcource.auth.screen.login.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun LoginTitleView() {
    Text(
        modifier = Modifier
            .fillMaxWidth(),
        color = MaterialTheme.colorScheme.secondary,
        fontStyle = MaterialTheme.typography.headlineLarge.fontStyle,
        fontSize = MaterialTheme.typography.headlineLarge.fontSize,
        text = "Вход"
    )
}
