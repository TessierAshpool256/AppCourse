package org.appcourse.course_list.ui.screen.favorite

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import org.appcourse.course_list.Screen
import org.appcourse.course_list.ui.CourseListState
import org.appcourse.course_list.ui.CoursesViewModel
import org.appcourse.course_list.ui.screen.ListError
import org.appcourse.course_list.ui.screen.ListLoading


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
