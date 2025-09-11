package org.appcourse.course_list.ui.screen

import android.annotation.SuppressLint
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import org.appcourse.course_list.Screen
import org.appcourse.course_list.ui.CoursesViewModel


@SuppressLint("RememberReturnType")
@Composable
fun AccountScreen(
    viewModel: CoursesViewModel = hiltViewModel<CoursesViewModel>()
) {
    Text("AccountScreen")
    remember { viewModel.openScreen(Screen.Account) }
}
