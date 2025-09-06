package org.appcourse.course_list.ui.screen

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import org.appcourse.navigation.NavContract


private const val LOG_TAG = "home"

@Composable
fun HomeScreen(
    nav: NavContract
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
                onClick = { nav.navigateToHome() }
            ) {
                Text("Home")
            }
        }
    }
}
