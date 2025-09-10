package org.appcourse.course_list.ui.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.appcourse.ui_theme.AppCourseTheme


@Composable
fun CourseListLoading() {
    Box(
        modifier = Modifier
            .fillMaxSize(1f),
        contentAlignment = Alignment.TopCenter
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .padding(16.dp)
                .width(64.dp),
            color = MaterialTheme.colorScheme.secondary,
            trackColor = MaterialTheme.colorScheme.primary,
        )
    }
}

@Preview(device = "id:pixel_9", showBackground = true)
@Composable
fun PrevieCourseListLoading() {
    AppCourseTheme {
        CourseListLoading()
    }
}
