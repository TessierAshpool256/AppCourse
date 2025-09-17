package org.appcourse.course.ui.ui.screen.favorite.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier


@Composable
fun FavoritListHead() {
    Row(
        modifier = Modifier.Companion
            .fillMaxWidth(fraction = .9f),
        horizontalArrangement = Arrangement.Start
    ) {
        Text(
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.titleLarge,
            text = "Избранное"
        )
    }
}
