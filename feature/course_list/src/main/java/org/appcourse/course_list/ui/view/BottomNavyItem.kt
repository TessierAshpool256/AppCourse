package org.appcourse.course_list.ui.view

import androidx.compose.ui.graphics.vector.ImageVector


data class BottomNavyItem(
    val title: String,
    val icon: ImageVector,
    var isSelected: Boolean = false
)
