package org.appcourse.data

import kotlinx.coroutines.flow.Flow
import org.appcourse.cours_api.CourseApi
import org.appcourse.course_list.ui.CourseRepository
import org.appcourse.course_list.ui.models.CourseEntity
import org.appcourse.db.CourseDatabase
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.Result


@Singleton
class CourseRepositoryImpl @Inject constructor(
    private val api: CourseApi,
    private val db: CourseDatabase,
) : CourseRepository {

    override fun getCourses(forceRefresh: Boolean): Flow<Result<List<CourseEntity>>> {
        TODO("Not yet implemented")
    }
}