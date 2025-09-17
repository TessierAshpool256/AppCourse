package org.appcourse.course.ui.ui.screen.home

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import org.appcourse.course.ui.Screen
import org.appcourse.course.ui.models.SortOrder
import org.appcourse.course.ui.ui.CourseListState
import org.appcourse.course.ui.ui.CoursesViewModel
import org.appcourse.course.ui.ui.screen.ListError
import org.appcourse.course.ui.ui.screen.ListLoading


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
