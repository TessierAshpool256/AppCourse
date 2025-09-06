package org.appcourse.course_list.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun DrawBottomNavButton(
    button: BottomNavyItem
) {
    Card(
        modifier = Modifier.Companion.fillMaxHeight(fraction = 0.9f)
    ) {
        Column(
            horizontalAlignment = Alignment.Companion.CenterHorizontally
        ) {
            Icon(
                imageVector = button.icon,
                contentDescription = button.title,
                tint = MaterialTheme.colorScheme.primary
            )
            Text(button.title)
        }
    }
}
