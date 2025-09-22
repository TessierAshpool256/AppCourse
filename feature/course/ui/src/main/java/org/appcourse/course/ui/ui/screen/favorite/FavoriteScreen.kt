package org.appcourse.course.ui.ui.screen.favorite

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import org.appcourse.course.ui.Screen
import org.appcourse.course.ui.ui.CourseListState
import org.appcourse.course.ui.ui.CoursesViewModel
import org.appcourse.course.ui.ui.screen.ListError
import org.appcourse.course.ui.ui.screen.ListLoading


@SuppressLint("RememberReturnType")
@Composable
fun FavoriteScreen(
    viewModel: CoursesViewModel = hiltViewModel<CoursesViewModel>()
) {
    remember { viewModel.openScreen(Screen.Favorite) }
    val courses = viewModel.favoriteCourses().collectAsState().value

    FavoriteContent(
        uiState = courses,
        toggleFavorite = viewModel::toggleFavorite
    )
}


@Composable
internal fun FavoriteContent(
    uiState: CourseListState,
    toggleFavorite: ((Long, Boolean)-> Unit),
) {
    when (uiState) {
        is CourseListState.Loading -> ListLoading()
        is CourseListState.Error   -> ListError(uiState.massage)
        is CourseListState.Success -> FavoriteList(
            courses = uiState.list,
            toggleFavorite = toggleFavorite
        )
    }
}
