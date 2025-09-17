package org.appcourse.course.ui.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import org.appcourse.course.ui.Screen
import org.appcourse.course.ui.models.SortOrder
import org.appcourse.course.ui.repository.CourseRepository
import org.appcourse.course.ui.ui.view.BottomNavyItem
import org.appcourse.navigation.NavContract
import javax.inject.Inject
import kotlin.collections.filter
import kotlin.collections.sortedBy


@HiltViewModel
class CoursesViewModel @Inject constructor (
    private val courseRepository : CourseRepository,
    private val navigator: NavContract
): ViewModel() {
    private val rawCourses : StateFlow<CourseListState> = courseRepository
        .getCourses()
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = CourseListState.Loading
        )

    private var _sortOrder = MutableStateFlow(SortOrder.ById)
    val sortOrder: StateFlow<SortOrder> = _sortOrder.asStateFlow()

    fun changeSortOrder() {
        if (_sortOrder.value == SortOrder.ById)
            _sortOrder.value =  SortOrder.ByPublishDate
        else
            _sortOrder.value =  SortOrder.ById
    }

    fun favoriteCourses(): StateFlow<CourseListState> {
        return rawCourses.map { state ->
                when (state) {
                    is CourseListState.Success ->
                        CourseListState.Success(
                            state.list.filter { course -> course.hasLike }
                        )
                    else -> state
                }
            }
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
                initialValue = CourseListState.Loading
            )
    }

    val courses: StateFlow<CourseListState> = combine(
        rawCourses,
        _sortOrder
    ) { state, order ->
        when (state) {
            is CourseListState.Success -> {
                val sorted = when (order) {
                    SortOrder.ById -> state.list.sortedBy { it.id }
                    SortOrder.ByPublishDate -> state.list.sortedBy { it.publishDate }
                }
                CourseListState.Success(sorted)
            }
            else -> state
        }
    }
        .onStart { emit(CourseListState.Loading) }
        .catch { e -> emit(CourseListState.Error()) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5_000),
            initialValue = CourseListState.Loading
        )

    fun toggleFavorite(courseId: Long, currentlyFav: Boolean) {
        viewModelScope.launch {
            courseRepository.setFavorite(courseId, currentlyFav)
        }
    }

    fun openScreen(openScreen: Screen) {
        buttonList.forEach { it.isSelected.value = false }

        buttonList.find { it.screen.title == openScreen.title }?.isSelected?.value = true
    }

    val buttonList = listOf(
        BottomNavyItem(Screen.Home),
        BottomNavyItem(Screen.Favorite),
        BottomNavyItem(Screen.Account)
    )
}
