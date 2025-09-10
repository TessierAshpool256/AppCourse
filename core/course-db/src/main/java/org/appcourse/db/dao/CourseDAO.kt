package org.appcourse.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import kotlinx.coroutines.flow.Flow
import org.appcourse.db.models.CourseDBO


@Dao
interface CourseDAO {
    // Insert
    @Upsert
    suspend fun insertCourse(course: CourseDBO): Long

    @Upsert
    suspend fun insertCourses(courses: List<CourseDBO>): List<Long>


    // Read
    @Query("SELECT * FROM course")
    fun getAllCourses(): Flow<List<CourseDBO>>

    @Query("SELECT * FROM course WHERE id = :id")
    suspend fun getCourse(id: Long): CourseDBO?
}
