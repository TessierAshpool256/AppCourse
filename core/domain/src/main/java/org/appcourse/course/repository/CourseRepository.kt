package org.appcourse.course.repository

import kotlinx.coroutines.flow.Flow
import org.appcourse.course.entity.CourseEntity


interface CourseRepository {

    fun getCourses(forceRefresh: Boolean = false): Flow<List<CourseEntity>>

    suspend fun setFavorite(courseId: Long, favorite: Boolean)
}
