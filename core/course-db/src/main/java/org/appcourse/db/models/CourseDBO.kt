package org.appcourse.db.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


/**
 * CourseDBO
 *
 * @param id идентификатор курса
 * @param title заголовок курса
 * @param text описание курса.
 * @param price цена курса
 * @param rate рейтинг курса
 * @param startDate дата начала курса
 * @param hasLike признак, добавлен ли курс в избранное
 * @param publishDate дата публикации курса
 */
@Entity(tableName = "course")
data class CourseDBO(
    @PrimaryKey
    @ColumnInfo("id")
    var id: Int? = null,
    @ColumnInfo("title")
    var title: String? = null,
    @ColumnInfo("text")
    var text: String? = null,
    @ColumnInfo("price")
    var price: String? = null,
    @ColumnInfo("rate")
    var rate: String? = null,
    @ColumnInfo("startDate")
    var startDate: String? = null,
    @ColumnInfo("hasLike")
    var hasLike: Boolean? = null,
    @ColumnInfo("publishDate")
    var publishDate: String? = "",
)
