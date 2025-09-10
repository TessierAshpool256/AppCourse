package org.appcourse.course_list.ui.screen.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import org.appcourse.course_list.ui.CourseListState
import org.appcourse.course_list.ui.view.CourseView
import org.appcourse.course_list.utile.mockCoursesList
import org.appcourse.ui_theme.AppCourseTheme

@Composable
fun CourseListSuccess(
    courses: CourseListState.Success
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
    ) {
        items(courses.list, key = { it.id }) { course ->
            CourseView(course)
        }
    }
}


@Preview(device = "id:pixel_9", showBackground = true)
@Composable
fun PreviewCourseListSuccess() {
    AppCourseTheme {
        CourseListSuccess(CourseListState.Success(mockCoursesList()))
    }
}