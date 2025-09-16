package org.appcource.auth.screen.login.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import org.appcource.auth.R
import org.appcourse.ui_theme.TextInTextFiled


@Composable
fun PasswordInputField(
    label: String,
    exampleText: String,
    password: String,
    changeLogin: ((String) -> Unit)
) {
    var showPassword by remember { mutableStateOf(false) }

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
            if (password.isEmpty())
                Text(
                    style = MaterialTheme.typography.bodyMedium,
                    modifier = Modifier.padding(start = 16.dp),
                    color = TextInTextFiled,
                    text = exampleText
                )
            Row(
                modifier = Modifier.fillMaxWidth(1f),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                BasicTextField(
                    modifier = Modifier
                        .weight(weight = .8f)
                        .padding(start = 16.dp),
                    cursorBrush = SolidColor(MaterialTheme.colorScheme.secondary),
                    textStyle = TextStyle(color = MaterialTheme.colorScheme.secondary),
                    value = password,
                    onValueChange = changeLogin,
                    visualTransformation = if (showPassword) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        keyboardType = KeyboardType.Ascii
                    ),
                )

                Icon(
                    modifier = Modifier
                        .weight(weight = .1f)
                        .padding(end = 12.dp)
                        .clickable { showPassword = !showPassword }
                        .size(17.dp),
                    tint = TextInTextFiled,
                    painter = if (!showPassword)
                        painterResource(id = R.drawable.ic_eye)
                    else
                        painterResource(id = R.drawable.ic_eye_crossed),
                    contentDescription = "View password"
                )
            }
        }
    }
}
