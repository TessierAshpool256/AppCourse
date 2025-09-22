package org.appcource.auth.screen.login.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import org.appcourse.ui_theme.TextInTextFiled


@Composable
fun LoginInputField(
    label: String,
    exampleText: String,
    login: String,
    changeLogin: ((String) -> Unit)
) {
    Text(
        modifier = Modifier.padding(bottom = 8.dp),
        style = MaterialTheme.typography.titleMedium,
        color = MaterialTheme.colorScheme.secondary,
        text = label
    )

    Card(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(40.dp),
        shape = MaterialTheme.shapes.extraLarge,
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize(1f),
            contentAlignment = Alignment.CenterStart
        ) {
            if (login.isEmpty()) Text(
                modifier = Modifier.padding(start = 16.dp),
                style = MaterialTheme.typography.bodyMedium,
                color = TextInTextFiled,
                text = exampleText
            )

            BasicTextField(
                modifier = Modifier
                    .padding(start = 16.dp),
                cursorBrush = SolidColor(MaterialTheme.colorScheme.secondary),
                textStyle = TextStyle(color = MaterialTheme.colorScheme.secondary),
                value = login,
                onValueChange = changeLogin,
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Ascii
                ),
            )
        }
    }
}
