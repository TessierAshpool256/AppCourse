package org.appcourse.course_list.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import org.appcourse.course_list.ui.CourseListState
import org.appcourse.course_list.ui.screen.home.view.CourseView
import org.appcourse.course_list.ui.screen.home.view.FindFilterHeader
import org.appcourse.course_list.utile.mockCoursesList
import org.appcourse.ui_theme.AppCourseTheme


@Composable
fun CourseListSuccess(
    courses: List<CourseEntity>,
    sortOrder: SortOrder,
    changeSortOrder: (() -> Unit),
    toggleFavorite: ((Long, Boolean)-> Unit),
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item(key = Long.MIN_VALUE) {
            FindFilterHeader(search)
        }
        items(courses, key = { it.id }) { course ->
            CourseView(course, toggleFavorite)
        }
        item(key = Long.MAX_VALUE) {
            Spacer(modifier = Modifier.padding(8.dp))
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@Preview(device = "id:pixel_9", showBackground = true)
@Composable
fun PreviewCourseListSuccess() {
    AppCourseTheme {
        Box(
            modifier = Modifier
                .fillMaxSize(1f)
                .background(MaterialTheme.colorScheme.background)
        ) {
            Spacer(modifier = Modifier.padding(8.dp))
            CourseListSuccess(
                mockCoursesList(),
                SortOrder.ById,
                {},
                {_, _ -> }
            )
        }
    }
}