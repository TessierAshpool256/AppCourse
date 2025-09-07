package org.appcourse.course_list.ui.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.appcourse.navigation.FakeNavigator
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
        modifier = Modifier
            .height(72.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        buttonList.forEach {
            DrawBottomNavButton(it)
        }
    }
}

@Preview(
    name = "Light Theme",
    showBackground = true,
    widthDp = 400,
    heightDp = 200,
    backgroundColor = 0xFFFFFFFF
)
@Composable
private fun BottomNavBarPreview() {
    MaterialTheme {
        BottomNavBar(FakeNavigator())
    }
}