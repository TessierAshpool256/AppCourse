package org.appcourse.course.ui.ui

import org.appcourse.course.entity.CourseEntity


sealed interface CourseListState {
    object Loading : CourseListState

    data class Success(val list: List<CourseEntity>) : CourseListState

    data class Error(val massage: String = "Error") : CourseListState
}
