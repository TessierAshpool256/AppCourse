package org.appcourse.course.ui.repository

import kotlinx.coroutines.flow.Flow
import org.appcourse.course.ui.ui.CourseListState


interface CourseRepository {

    fun getCourses(forceRefresh: Boolean = false): Flow<CourseListState>

    suspend fun setFavorite(courseId: Long, favorite: Boolean)
}
