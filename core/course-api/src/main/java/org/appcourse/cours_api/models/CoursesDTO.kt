package org.appcourse.cours_api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CoursesDTO(
    @SerialName("courses")
    val list: List<CourseDTO>
)

