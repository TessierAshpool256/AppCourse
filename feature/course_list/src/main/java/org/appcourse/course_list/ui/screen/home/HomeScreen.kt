package org.appcourse.course_list.ui.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import org.appcourse.course_list.ui.CourseListState
import org.appcourse.course_list.ui.CoursesViewModel


private const val LOG_TAG = "home"

@Composable
fun HomeScreen(
    viewModel: CoursesViewModel = hiltViewModel<CoursesViewModel>()
) {
    val courses = viewModel.courses.collectAsState().value

    when (courses) {
        is CourseListState.Loading -> {
            CourseListLoading()
        }
        is CourseListState.Error -> {
            CourseListError()
        }
        is CourseListState.Success -> {
            CourseListSuccess(courses)
        }
    }
}


