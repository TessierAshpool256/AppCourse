package org.appcourse.course_list.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.appcourse.navigation.NavContract


@Composable
fun DrawScreenFrame(
    nav: NavContract,
    content: (@Composable () -> Unit)
) {
    Scaffold(
        bottomBar = { BottomNavBar(nav) }
    ) { innerPadding ->
        Box(
            modifier = Modifier.padding(innerPadding)
        ) {
            content.invoke()
        }
    }
}
