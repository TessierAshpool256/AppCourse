package org.appcourse.course_list.ui.screen.home.view

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import org.appcourse.course_list.R
import org.appcourse.course_list.models.SortOrder
import org.appcourse.ui_theme.AppCourseTheme


@Composable
fun FindFilterHeader(
    sortOrder: SortOrder,
    changeSortOrder: (() -> Unit)
) {
    var search by remember { mutableStateOf("") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(.9f)
        ) {
            Row(
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth(.8f)
                        .height(56.dp)
                        .background(
                            color = MaterialTheme.colorScheme.tertiary,
                            shape = MaterialTheme.shapes.extraLarge
                        )
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxSize(),
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.padding(8.dp))

                        Box(
                            modifier = Modifier
                        ) {
                            Icon(
                                modifier = Modifier
                                    .size(28.dp),
                                painter = painterResource(R.drawable.search),
                                tint = MaterialTheme.colorScheme.secondary,
                                contentDescription = "find",
                            )
                        }

                        Spacer(modifier = Modifier.padding(8.dp))

                        Box {
                            Text(
                                color = MaterialTheme.colorScheme.onTertiary,
                                text = "Search courses..."
                            )
                            BasicTextField(
                                modifier = Modifier
                                    .fillMaxWidth(.95f),
                                cursorBrush = SolidColor(MaterialTheme.colorScheme.secondary),
                                textStyle = TextStyle(color = MaterialTheme.colorScheme.secondary),
                                value = search,
                                onValueChange = { newText ->
                                    search = newText
                                },
                                keyboardOptions = KeyboardOptions.Default.copy(
                                    keyboardType = KeyboardType.Ascii
                                ),
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.padding(8.dp))

                Box(
                    modifier = Modifier
                        .size(56.dp)
                        .background(
                            color = MaterialTheme.colorScheme.tertiary,
                            shape = MaterialTheme.shapes.extraLarge
                        )
                        .aspectRatio(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        modifier = Modifier
                            .size(28.dp),
                        painter = painterResource(R.drawable.funnel),
                        tint = MaterialTheme.colorScheme.secondary,
                        contentDescription = "Filter"
                    )
                }
            }

            Spacer(modifier = Modifier.padding(vertical = 4.dp))

            Row(
                Modifier
                    .fillMaxWidth(1f),
                horizontalArrangement = Arrangement.End,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Row(
                    modifier = Modifier
                        .clickable { changeSortOrder.invoke() },
                    horizontalArrangement = Arrangement.End
                ) {
                    Text(
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodySmall,
                        text = sortOrder.text
                    )

                    Icon(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(R.drawable.arrow_down_up),
                        contentDescription = "",
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}


@SuppressLint("UnrememberedMutableState")
@Preview(device = "spec:width=1080px,height=2424px", showBackground = true)
@Composable
fun PreviewFindFilterHeader() {
    AppCourseTheme {
        Box(
            modifier = Modifier
                .background(Color.White)
                .fillMaxSize(1f),
            contentAlignment = Alignment.Center
        ) {
            Box(
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.background),
            ) {
                FindFilterHeader(
                    sortOrder = SortOrder.ById,
                    changeSortOrder = {}
                )
            }
        }
    }
}
