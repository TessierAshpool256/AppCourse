package org.appcourse.db.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import org.appcourse.db.models.CourseDBO


@Dao
interface CourseDAO {
    // Insert
    @Upsert
    suspend fun insertCourse(course: CourseDAO): Long

    @Upsert
    suspend fun insertCourses(courses: List<CourseDAO>): List<Long>


    // Read
    @Query("SELECT * FROM course")
    suspend fun getAllCourses(): List<CourseDBO>?

    @Query("SELECT * FROM course WHERE id = :id")
    suspend fun getCourse(id: Long): CourseDBO?
}
