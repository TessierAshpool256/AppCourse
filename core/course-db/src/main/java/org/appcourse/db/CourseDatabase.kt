package org.appcourse.db

import android.content.Context
import androidx.room.Room
import org.appcourse.db.dao.CourseDAO


class CourseDatabase internal constructor(
    private val db: CourseRoomDatabase
) {
    val course: CourseDAO
        get() = db.course()
}


fun CourseDatabase(
    applicationContext: Context
) = CourseDatabase(
    Room.databaseBuilder(
        context = checkNotNull(applicationContext.applicationContext),
        name = "course",
        klass = CourseRoomDatabase::class.java
    ).build()
)
