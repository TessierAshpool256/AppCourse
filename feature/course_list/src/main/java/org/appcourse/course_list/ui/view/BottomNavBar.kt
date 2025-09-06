package org.appcourse.course_list.ui.view

import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import org.appcourse.navigation.NavContract


@Composable
fun BottomNavBar(
//    buttonList: List<BottomNavItem>,
    nav: NavContract
) {
    val buttonList = remember {
        listOf(
            BottomNavyItem("Главная", Icons.Outlined.Phone),
            BottomNavyItem("Избранное", Icons.Outlined.Phone),
            BottomNavyItem("Аккаунт", Icons.Outlined.Phone)
        )
    }

    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        buttonList.forEach {
            DrawBottomNavButton(it)
        }
    }
}
