package org.appcourse.course_list.ui

import kotlinx.coroutines.flow.Flow
import org.appcourse.course_list.ui.models.CourseEntity


interface CourseRepository {

    fun getCourses(forceRefresh: Boolean = false): Flow<Result<List<CourseEntity>>>
}
