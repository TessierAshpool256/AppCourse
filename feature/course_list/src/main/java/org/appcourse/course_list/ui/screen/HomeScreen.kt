package org.appcourse.course_list.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation3.runtime.NavKey
import org.appcourse.navigation.AppNavigation
import org.appcourse.navigation.HomeNav


private const val LOG_TAG = "home"

@Composable
fun HomeScreen(
    appBackStack: (() -> AppNavigation<NavKey>)
) {
    Log.d(LOG_TAG, "HomeScreen")
    Column(
        verticalArrangement = Arrangement.Center
    ) {
        Text("HomeScreen")
        Row(
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = {appBackStack.invoke().add(HomeNav) }
            ) {
                Text("Home")
            }
        }
    }
}
