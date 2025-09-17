package org.appcourse.course.ui.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import org.appcourse.course.ui.ui.CoursesViewModel
import org.appcourse.navigation.NavContract


@Composable
fun DrawScreenFrame(
    nav: NavContract,
    viewModel: CoursesViewModel = hiltViewModel<CoursesViewModel>(),
    content: (@Composable () -> Unit)
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(1f),
        bottomBar = { BottomNavBar(
            nav,
            viewModel.buttonList
        ) }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize(1f)
                .padding(innerPadding)
        ) {
            content.invoke()
        }
    }
}
