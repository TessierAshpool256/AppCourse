package org.appcource.auth.ui.screen.login

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.coroutines.launch
import org.appcource.auth.AuthViewModel
import org.appcource.auth.FakeAuthViewModel
import org.appcource.auth.R
import org.appcourse.ui_theme.AppCourseTheme
import org.appcourse.ui_theme.OkColor
import org.appcourse.ui_theme.TextInTextFiled
import org.appcourse.ui_theme.VkColor


internal const val LOG_TAG = "login"

@Composable
fun LoginScreen(
    viewModel: AuthViewModel = hiltViewModel<AuthViewModel>()
) {
    val alphanumericRegex = remember { Regex("""^[A-Za-z0-9@_.]*$""") }

    val coroutineScope = rememberCoroutineScope()
    var showPassword by remember { mutableStateOf(false) }

    var login by viewModel.login
    var password by viewModel.password
    var isError by viewModel.isError

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
                Text(
                    modifier = Modifier
                        .fillMaxWidth(),
                    color = MaterialTheme.colorScheme.secondary,
                    fontStyle = MaterialTheme.typography.headlineLarge.fontStyle,
                    fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                    text = "Вход"
                )

                Spacer(modifier = Modifier.padding(vertical = 8.dp))

                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary,
                    text = "Email"
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
                            text = "example@gmail.com"
                        )

                        BasicTextField(
                            modifier = Modifier.padding(start = 16.dp),
                            cursorBrush = SolidColor(MaterialTheme.colorScheme.secondary),
                            textStyle = TextStyle(color = MaterialTheme.colorScheme.secondary),
                            value = login,
                            onValueChange = { newText ->
                                if (alphanumericRegex.matches(newText)) {
                                    login = newText
                                }
                            },
                            keyboardOptions = KeyboardOptions.Default.copy(
                                keyboardType = KeyboardType.Ascii
                            ),
                        )
                    }
                }

                Spacer(modifier = Modifier.padding(top = 16.dp))

                Text(
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .fillMaxWidth(1f),
                    color = MaterialTheme.colorScheme.secondary,
                    style = MaterialTheme.typography.titleMedium,
                    text = "Пароль"
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
                                text = "Введите пароль"
                            )
                        Row(
                            modifier = Modifier.fillMaxWidth(1f),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            BasicTextField(
                                modifier = Modifier
                                    .weight(.8f)
                                    .padding(start = 16.dp),
                                cursorBrush = SolidColor(MaterialTheme.colorScheme.secondary),
                                textStyle = TextStyle(color = MaterialTheme.colorScheme.secondary),
                                value = password,
                                onValueChange = { newText ->
                                    if (alphanumericRegex.matches(newText)) {
                                        password = newText
                                    } else {
                                        Log.d(LOG_TAG, "Password field incorrect char")
                                    }
                                },
                                visualTransformation = if (showPassword) VisualTransformation.None
                                else PasswordVisualTransformation(),
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    keyboardType = KeyboardType.Ascii
                                ),
                            )

                            Icon(
                                modifier = Modifier
                                    .weight(.1f)
                                    .padding(end = 12.dp)
                                    .clickable { showPassword = !showPassword }
                                    .size(17.dp),
                                tint = MaterialTheme.colorScheme.onTertiary,
                                painter = if (!showPassword)
                                    painterResource(id = R.drawable.ic_eye)
                                else
                                    painterResource(id = R.drawable.ic_eye_crossed),
                                contentDescription = "View password"
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.padding(top = 16.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    colors = ButtonColors(
                        contentColor = MaterialTheme.colorScheme.secondary,
                        containerColor = MaterialTheme.colorScheme.primary,
                        disabledContentColor = MaterialTheme.colorScheme.secondary,
                        disabledContainerColor = MaterialTheme.colorScheme.primary
                    ),
                    onClick = {
                        Log.d(LOG_TAG, "Push login button")
                        coroutineScope.launch {
                            viewModel.login()
                        }
                    }
                ) {
                    Text("Вход")
                }

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
                                .clickable { viewModel.goToRegistration() },
                            color = MaterialTheme.colorScheme.primary,
                            text = "регистрация"
                        )
                    }
                    Text(
                        modifier = Modifier
                            .clickable { viewModel.goToRegistration() },
                        color = MaterialTheme.colorScheme.primary,
                        text = "Забыл пароль"
                    )
                }

                Spacer(modifier = Modifier.padding(top = 32.dp))

                HorizontalDivider(
                    color = MaterialTheme.colorScheme.tertiary
                )

                Spacer(modifier = Modifier.padding(top = 24.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth(1f),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),

                ) {
                    Button(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(1f),
                        onClick = { viewModel.goToVkMedia() },
                        colors = ButtonColors(
                            containerColor = VkColor,
                            contentColor = MaterialTheme.colorScheme.secondary,
                            disabledContainerColor = VkColor,
                            disabledContentColor = MaterialTheme.colorScheme.secondary
                        )
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_vk),
                            contentDescription = "Vkontakte link"
                        )
                    }
                    Button(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxWidth(1f),
                        colors = ButtonColors(
                            containerColor = OkColor,
                            contentColor = MaterialTheme.colorScheme.secondary,
                            disabledContainerColor = OkColor,
                            disabledContentColor = MaterialTheme.colorScheme.secondary
                        ),
                        onClick = { viewModel.goToOkMedia() }
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_ok),
                            contentDescription = "Odnoklassniki link"
                        )
                    }
                }
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

