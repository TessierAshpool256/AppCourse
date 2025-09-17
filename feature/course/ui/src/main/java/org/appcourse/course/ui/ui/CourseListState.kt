package org.appcourse.course.ui.ui

import org.appcourse.course.ui.models.CourseEntity


sealed class CourseListState {
    object Loading : CourseListState()

    data class Success(val list: List<CourseEntity>) : CourseListState()

    data class Error(val massage: String = "Error") : CourseListState()
}
