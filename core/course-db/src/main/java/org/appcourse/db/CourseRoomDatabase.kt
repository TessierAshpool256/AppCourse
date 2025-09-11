package org.appcourse.db

import androidx.room.Database
import androidx.room.RoomDatabase
import org.appcourse.db.dao.CourseDAO
import org.appcourse.db.models.CourseDBO


@Database(
    entities = [
        CourseDBO::class
    ],
    version = 1
)
abstract class CourseRoomDatabase : RoomDatabase() {
    abstract fun course(): CourseDAO
}
