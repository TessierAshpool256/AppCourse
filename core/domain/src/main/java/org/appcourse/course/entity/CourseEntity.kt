package org.appcourse.course.entity


data class CourseEntity(
    var id: Long,
    var title: String,
    var text: String,
    var price: String,
    var rate: String,
    var startDate: String,
    var hasLike: Boolean,
    var publishDate: String = "",
)
