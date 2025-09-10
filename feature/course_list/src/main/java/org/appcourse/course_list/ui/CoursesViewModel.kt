package org.appcourse.course_list.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.appcourse.course_list.R
import org.appcourse.course_list.ui.view.BottomNavyItem
import org.appcourse.navigation.NavContract
import javax.inject.Inject


@HiltViewModel
class CoursesViewModel @Inject constructor (
    private val courseRepository : CourseRepository,
    private val navigator: NavContract
): ViewModel() {
    val buttonList = listOf(
        BottomNavyItem("Главная", R.drawable.ic_house, isSelected = mutableStateOf(true)) { navigator.navigateToHome() },
        BottomNavyItem("Избранное", R.drawable.ic_bookmark) { navigator.navigateToLikeCourse() },
        BottomNavyItem("Аккаунт", R.drawable.ic_person) { navigator.navigateToAccount() }
    )

    val courses : StateFlow<CourseListState> = courseRepository
        .getCourses()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = CourseListState.Loading
        )
}
