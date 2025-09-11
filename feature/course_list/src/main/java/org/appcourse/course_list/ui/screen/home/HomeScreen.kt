package org.appcourse.course_list.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import org.appcourse.course_list.Screen
import org.appcourse.course_list.models.SortOrder
import org.appcourse.course_list.ui.CourseListState
import org.appcourse.course_list.ui.CoursesViewModel
import org.appcourse.course_list.ui.screen.ListError
import org.appcourse.course_list.ui.screen.ListLoading


@SuppressLint("RememberReturnType")
@Composable
fun HomeScreen(
    viewModel: CoursesViewModel = hiltViewModel<CoursesViewModel>()
) {
    remember { viewModel.openScreen(Screen.Home) }

    val courses = viewModel.courses.collectAsState().value
    val sortOrder = viewModel.sortOrder.collectAsState().value

    HomeContent(
        uiState = courses,
        sortOrder = sortOrder,
        changeSortOrder = viewModel::changeSortOrder,
        toggleFavorite = viewModel::toggleFavorite
    )
}


@Composable
internal fun HomeContent(
    uiState: CourseListState,
    sortOrder: SortOrder,
    changeSortOrder: (() -> Unit),
    toggleFavorite: ((Long, Boolean)-> Unit)
) {
    when (uiState) {
        is CourseListState.Loading -> ListLoading()
        is CourseListState.Error   -> ListError(uiState.massage)
        is CourseListState.Success -> CourseList(
            courses = uiState.list,
            sortOrder = sortOrder,
            changeSortOrder = changeSortOrder,
            toggleFavorite = toggleFavorite
        )
    }
}
