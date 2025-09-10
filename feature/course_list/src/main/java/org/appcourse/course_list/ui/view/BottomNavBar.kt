package org.appcourse.course_list.ui.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.appcourse.course_list.R
import org.appcourse.navigation.FakeNavigator
import org.appcourse.navigation.NavContract
import org.appcourse.ui_theme.AppCourseTheme


@Composable
fun DrawBottomNavButton(
    item: BottomNavyItem,
    click: (() -> Unit)
) {
    Column(
        horizontalAlignment = Alignment.Companion.CenterHorizontally
    ) {
        val backColor = if (item.isSelected.value)
            MaterialTheme.colorScheme.onTertiary
        else
            MaterialTheme.colorScheme.tertiary

        val mainColor = if (item.isSelected.value)
            MaterialTheme.colorScheme.primary
        else
            MaterialTheme.colorScheme.secondary

        Card(
            modifier = Modifier
                .padding(bottom = 4.dp)
                .clickable { click.invoke() },
            colors = CardColors(
                containerColor = backColor,
                contentColor = mainColor,
                disabledContentColor = backColor,
                disabledContainerColor = mainColor,
            )
        ) {
            Box(
                modifier = Modifier
                    .size(width = 64.dp, height = 32.dp),
                contentAlignment = Alignment.Center,
            ) {
                Icon(
                    painter = painterResource(item.icon),
                    contentDescription = item.title,
                )
            }
        }
        Text(
            modifier = Modifier
                .clickable { click.invoke() },
            style = MaterialTheme.typography.labelMedium,
            color = mainColor,
            text = item.title
        )
        Spacer(modifier = Modifier.padding(bottom = 16.dp))
    }
}


@Composable
fun BottomNavBar(
    nav: NavContract,
    buttonList: List<BottomNavyItem>
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .background(MaterialTheme.colorScheme.tertiary)
            .height(88.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceAround,
    ) {
        buttonList.forEach {
            DrawBottomNavButton(it) {
                buttonList.find { it.isSelected.value }?.isSelected?.value = false
                it.isSelected.value = true
                it.goTo.invoke()
            }
        }
    }
}

@SuppressLint("UnrememberedMutableState")
@Preview(
    name = "Light Theme",
    showBackground = true,
    backgroundColor = 0xFFFFFFFF, device = "id:pixel_9"
)
@Composable
private fun BottomNavBarPreview() {
    AppCourseTheme {
        BottomNavBar(FakeNavigator(), listOf(
            BottomNavyItem(
                title = "Главная",
                icon = R.drawable.ic_house,
                isSelected = mutableStateOf(true)
            ) {},
            BottomNavyItem("Избранное", R.drawable.ic_bookmark) {},
            BottomNavyItem("Аккаунт", R.drawable.ic_person) {}
        ))
    }
}