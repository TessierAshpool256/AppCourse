package org.appcourse.course_list.utile

import org.appcourse.course_list.R

fun mockImageByCourseId(id: Long): Int {
    return when (id) {
        100L -> R.drawable.cover_1
        101L -> R.drawable.cover_2
        102L -> R.drawable.cover_3
        else -> R.drawable.cover_1
    }
}