package org.appcourse.course.ui.ui.screen

import android.annotation.SuppressLint
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import org.appcourse.course.ui.Screen
import org.appcourse.course.ui.ui.CoursesViewModel


@SuppressLint("RememberReturnType")
@Composable
fun AccountScreen(
    viewModel: CoursesViewModel = hiltViewModel<CoursesViewModel>()
) {
    Text("AccountScreen")
    remember { viewModel.openScreen(Screen.Account) }
}
