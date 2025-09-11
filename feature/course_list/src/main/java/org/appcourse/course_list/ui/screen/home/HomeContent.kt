package org.appcourse.course_list.ui.screen.home

import androidx.compose.runtime.Composable
import org.appcourse.course_list.ui.CourseListState
import org.appcourse.course_list.models.SortOrder


@Composable
internal fun HomeContent(
    uiState: CourseListState,
    sortOrder: SortOrder,
    changeSortOrder: (() -> Unit),
    toggleFavorite: ((Long, Boolean)-> Unit)
) {
    when (uiState) {
        is CourseListState.Loading -> CourseListLoading()
        is CourseListState.Error   -> CourseListError()
        is CourseListState.Success -> CourseListSuccess(
                courses = uiState.list,
                sortOrder = sortOrder,
                changeSortOrder = changeSortOrder,
                toggleFavorite = toggleFavorite
            )
    }
}