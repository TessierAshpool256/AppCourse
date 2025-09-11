package org.appcourse.data.mapper

import org.appcourse.cours_api.models.CourseDTO
import org.appcourse.course_list.models.CourseEntity
import org.appcourse.data.utile.formatRussianDate
import org.appcourse.db.models.CourseDBO


fun CourseDBO.toCourseEntity(): CourseEntity {
    return CourseEntity(
        id = this.id?.toLong() ?: 0,
        title = this.title.orEmpty(),
        text = this.text.orEmpty(),
        price = this.price.orEmpty(),
        rate = this.rate.orEmpty(),
        startDate = this.startDate?.formatRussianDate() ?: "",
        hasLike = this.hasLike ?: false,
        publishDate = this.publishDate?.formatRussianDate() ?: ""
    )
}

fun CourseDTO.toCourseDBO(): CourseDBO {
    return CourseDBO(
        id = this.id ?: 0,
        title = this.title.orEmpty(),
        text = this.text.orEmpty(),
        price = this.price.orEmpty(),
        rate = this.rate.orEmpty(),
        startDate = this.startDate.orEmpty(),
        hasLike = this.hasLike ?: false,
        publishDate = this.publishDate.orEmpty()
    )
}
