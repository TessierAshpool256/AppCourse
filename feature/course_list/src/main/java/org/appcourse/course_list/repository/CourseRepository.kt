package org.appcourse.course_list.repository

import kotlinx.coroutines.flow.Flow
import org.appcourse.course_list.ui.CourseListState


interface CourseRepository {

    fun getCourses(forceRefresh: Boolean = false): Flow<CourseListState>

    suspend fun setFavorite(courseId: Long, favorite: Boolean)
}
