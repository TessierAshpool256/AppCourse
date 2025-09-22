package org.appcourse.course.ui.ui.view

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import org.appcourse.course.ui.Screen


data class BottomNavyItem(
    val screen: Screen,
    var isSelected: MutableState<Boolean> = mutableStateOf(false)
)
