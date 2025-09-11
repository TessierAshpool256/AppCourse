package org.appcourse.course_list.ui

import org.appcourse.course_list.models.CourseEntity

sealed class CourseListState {
    object Loading : CourseListState()

    data class Success(val list: List<CourseEntity>) : CourseListState()

    data class Error(val massage: String = "Error") : CourseListState()
}
