package org.appcourse.data.utile

import kotlinx.datetime.LocalDate
import kotlinx.datetime.Month
import kotlinx.datetime.number
import kotlinx.datetime.toJavaMonth
import java.time.format.TextStyle
import java.util.Locale


fun String.formatRussianDate(): String {
    if (this.isEmpty()) return ""

    val parsedDate = LocalDate.parse(this)

    return "${parsedDate.day} ${
        Month(parsedDate.month.number)
            .toJavaMonth()
            .getDisplayName(
                TextStyle.FULL,
                Locale.forLanguageTag("ru")
            ).replaceFirstChar { it.uppercase() }
    } ${parsedDate.year}"
}
