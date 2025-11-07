package org.appcourse.course.ui.ui.view

import android.util.Log
import androidx.compose.foundation.layout.height
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarDefaults
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.appcourse.course.ui.Screen
import org.appcourse.navigation.NavApi
import org.appcourse.navigation.NavContract


@Composable
fun BottomNavBar(
    nav: NavContract,
    buttonList: List<Screen>,
    selectedDestination: Int
) {
    BottomAppBar(
        modifier = Modifier
            .height(88.dp),
    ) {
        NavigationBar(
            windowInsets = NavigationBarDefaults.windowInsets
        ) {
            buttonList.forEachIndexed { index, destination ->
                val isSelected = index == selectedDestination

                val mainColor = if (isSelected)
                    MaterialTheme.colorScheme.primary
                else
                    MaterialTheme.colorScheme.secondary

                NavigationBarItem(
                    selected = isSelected,
                    onClick = {
                        Log.d("Bottom nav", "new selected = $index")
                        nav.navigate(destination as NavApi)
                    },
                    icon = {
                        Icon(
                            painter = painterResource(destination.iconId),
                            tint = mainColor,
                            contentDescription = destination.title
                        )
                    },
                    label = {
                        Text(
                            text = destination.title,
                            color = mainColor
                        )
                    }
                )
            }
        }
    }
}
