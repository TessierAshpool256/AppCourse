package org.appcourse.cours_api.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class CourseDTO(
    @SerialName("id")
    var id: Int? = null,
    @SerialName("title")
    var title: String? = null,
    @SerialName("text")
    var text: String? = null,
    @SerialName("price")
    var price: String? = null,
    @SerialName("rate")
    var rate: String? = null,
    @SerialName("startDate")
    var startDate: String? = null,
    @SerialName("hasLike")
    var hasLike: Boolean? = null,
    @SerialName("publishDate")
    var publishDate: String? = null
)
