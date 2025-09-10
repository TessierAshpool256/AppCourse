package org.appcourse.course_list.ui.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import org.appcourse.course_list.ui.CoursesViewModel


@Composable
fun LikeScreen(
    viewModel: CoursesViewModel = hiltViewModel<CoursesViewModel>()
) {
    Text("LikeScreen", )

}
