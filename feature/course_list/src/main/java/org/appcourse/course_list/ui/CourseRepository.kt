package org.appcourse.course_list.ui

import kotlinx.coroutines.flow.Flow

interface CourseRepository {

    fun getCourses(forceRefresh: Boolean = false): Flow<CourseListState>
}
