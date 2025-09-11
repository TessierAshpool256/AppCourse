package org.appcourse.course_list.ui.screen.home

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import org.appcourse.course_list.ui.CoursesViewModel


private const val LOG_TAG = "home"

@Composable
fun HomeScreen(
    viewModel: CoursesViewModel = hiltViewModel<CoursesViewModel>()
) {
    val courses = viewModel.courses.collectAsState().value
    val sortOrder = viewModel.sortOrder.collectAsState().value

    HomeContent(
        uiState = courses,
        sortOrder = sortOrder,
        changeSortOrder = viewModel::changeSortOrder,
        toggleFavorite = viewModel::toggleFavorite
    )
}
