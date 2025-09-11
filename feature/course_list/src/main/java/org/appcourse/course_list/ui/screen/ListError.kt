package org.appcourse.course_list.ui.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.appcourse.ui_theme.AppCourseTheme


@Composable
fun ListError(
    massage: String
) {
    Box(
        modifier = Modifier.fillMaxSize(1f),
        contentAlignment = Alignment.Center
    ) {
        Text(text = massage)
    }
}


@Preview(device = "id:pixel_9", showBackground = true)
@Composable
fun PrevieCourseListError() {
    AppCourseTheme {
        ListError("Ошибка сети")
    }
}
