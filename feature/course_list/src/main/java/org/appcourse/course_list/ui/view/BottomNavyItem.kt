package org.appcourse.course_list.ui.view

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf


data class BottomNavyItem(
    val title: String,
    val icon: Int,
    var isSelected: MutableState<Boolean> = mutableStateOf(false),
    val goTo: (() -> Unit)
)
