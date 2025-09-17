package org.appcourse.data

import android.util.Log
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import org.appcourse.cours_api.CourseApi
import org.appcourse.course.ui.repository.CourseRepository
import org.appcourse.course.ui.ui.CourseListState
import org.appcourse.data.mapper.toCourseDBO
import org.appcourse.data.mapper.toCourseEntity
import org.appcourse.db.CourseDatabase
import javax.inject.Inject
import javax.inject.Singleton


internal const val LOG_TAG = "CourseRepo"

@Singleton
class CourseRepositoryImpl @Inject constructor(
    private val api: CourseApi,
    db: CourseDatabase,
) : CourseRepository {
    private val dao = db.course

    // Должен возвращать Flow<List<CourseEntity>>
    override fun getCourses(forceRefresh: Boolean): Flow<CourseListState> = flow {
        emit(CourseListState.Loading)

        val cacheFlow = dao.getAllCourses().map { list ->
            list.map { dbo ->
                dbo.toCourseEntity()
            }
        }.distinctUntilChanged()

        coroutineScope {
            launch(Dispatchers.IO) {
                val result = api.getCoursesList()
                val dto = result.getOrNull()
                if (result.isSuccess && dto != null) {
                    dao.insertCourses(dto.list.map { it.toCourseDBO() })
                } else {
                    Log.e(LOG_TAG, "Course list request error")
                }
            }

            cacheFlow.collect { cached ->
                emit(CourseListState.Success(cached))
            }
        }
    }

    override suspend fun setFavorite(courseId: Long, favorite: Boolean) {
        dao.updateFavorite(courseId, favorite)
    }
}
