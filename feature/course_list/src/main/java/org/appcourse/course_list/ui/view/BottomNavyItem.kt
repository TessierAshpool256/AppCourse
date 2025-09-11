package org.appcourse.course_list.ui.view

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import org.appcourse.course_list.Screen


data class BottomNavyItem(
    val screen: Screen,
    var isSelected: MutableState<Boolean> = mutableStateOf(false)
)
