package org.appcourse.course.ui.ui.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.appcourse.course.ui.Screen
import org.appcourse.navigation.NavContract


val buttonList: List<Screen> = listOf(
    Screen.Home,
    Screen.Favorite,
    Screen.Account
)

@Composable
fun DrawScreenFrame(
    nav: NavContract,
    selectionDescriptor: Int,
    content: (@Composable () -> Unit)
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize(1f),
        bottomBar = {
            BottomNavBar(
                nav = nav,
                buttonList = buttonList,
                selectedDestination = selectionDescriptor
            )
        }
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
