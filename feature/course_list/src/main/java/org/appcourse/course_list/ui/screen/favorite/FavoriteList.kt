package org.appcourse.course_list.ui.screen.favorite

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.appcourse.course_list.models.CourseEntity
import org.appcourse.course_list.ui.screen.favorite.view.FavoritListHead
import org.appcourse.course_list.ui.view.CourseView
import org.appcourse.course_list.utile.mockCoursesList
import org.appcourse.ui_theme.AppCourseTheme


@Composable
fun FavoriteList(
    courses: List<CourseEntity>,
    toggleFavorite: ((Long, Boolean) -> Unit)
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        item(key = Long.MIN_VALUE) {
            Spacer(modifier = Modifier.padding(8.dp))
            FavoritListHead()
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
fun PreviewFavoriteListSuccess() {
    AppCourseTheme {
        Box(
            modifier = Modifier
                .fillMaxSize(1f)
                .background(MaterialTheme.colorScheme.background)
        ) {
            Spacer(modifier = Modifier.padding(8.dp))
            FavoriteList(
                mockCoursesList()
            ) { _, _ -> }
        }
    }
}
