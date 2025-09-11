package org.appcource.auth.screen.login.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.appcource.auth.R
import org.appcourse.ui_theme.OkColor
import org.appcourse.ui_theme.VkColor


@Composable
fun MediaButtonView(
    goToVkMedia: (() -> Unit),
    goToOkMedia: (() -> Unit),
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Button(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(1f),
            onClick = { goToVkMedia()  },
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
            onClick = { goToOkMedia }
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_ok),
                contentDescription = "Odnoklassniki link"
            )
        }
    }
}