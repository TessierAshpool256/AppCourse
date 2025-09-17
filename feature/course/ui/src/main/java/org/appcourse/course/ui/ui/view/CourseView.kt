package org.appcourse.course.ui.ui.view

import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import dev.chrisbanes.haze.hazeEffect
import dev.chrisbanes.haze.hazeSource
import dev.chrisbanes.haze.rememberHazeState
import org.appcourse.course.ui.models.CourseEntity
import org.appcourse.course.ui.utile.mockCourse
import org.appcourse.course.ui.utile.mockImageByCourseId
import org.appcourse.course_list.R
import org.appcourse.ui_theme.AppCourseTheme
import org.appcourse.ui_theme.Glass
import kotlin.Boolean
import kotlin.Long
import kotlin.Unit


@Composable
fun CourseView(
    course: CourseEntity,
    toggleFavorite: ((Long, Boolean)-> Unit),
) {
    val hazeState = rememberHazeState()

    Box(
        modifier = Modifier
            .clip(MaterialTheme.shapes.medium)
            .background(MaterialTheme.colorScheme.tertiary)
            .fillMaxWidth(.9f),
    ) {
        Column {
            ConstraintLayout {
                val (rate, date, image, bookmark) = createRefs()
                Image(
                    modifier = Modifier
                        .hazeSource(hazeState, zIndex = 0f)
                        .constrainAs(image) {
                            top.linkTo(parent.top)
                            start.linkTo(parent.start)
                            end.linkTo(parent.end)
                        }
                        .fillMaxWidth(1f)
                    ,
                    contentScale = ContentScale.Crop,
                    painter = painterResource(mockImageByCourseId(course.id)),
                    contentDescription = "Course logo"
                )

                Box(
                    modifier = Modifier
                        .clip(RoundedCornerShape(16.dp))
                        .hazeSource(hazeState, zIndex = 1f)
                        .hazeEffect(hazeState)
                        .size(28.dp)
                        .constrainAs(bookmark) {
                            top.linkTo(parent.top, margin = 8.dp)
                            end.linkTo(parent.end, margin = 8.dp)
                        }
                        .background(Glass, shape = CircleShape)
                        .aspectRatio(1f),
                    contentAlignment = Alignment.Center
                ) {
                    Box (
                        modifier = Modifier
                            .clickable { toggleFavorite(course.id, !course.hasLike) }
                            .blur(radius = 16.dp)
                    )
                    Icon(
                        modifier = Modifier
                            .size(16.dp),
                        painter = if (course.hasLike)
                            painterResource(R.drawable.ic_bookmark_fill)
                        else
                            painterResource(R.drawable.ic_bookmark),
                        contentDescription = "Добавить в избранное",
                        tint = if (course.hasLike)
                            MaterialTheme.colorScheme.primary
                        else
                            MaterialTheme.colorScheme.secondary
                    )
                }

                Row(
                    modifier = Modifier
                        .height(22.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .hazeSource(hazeState, zIndex = 1f)
                        .hazeEffect(hazeState)
                        .constrainAs(rate) {
                            start.linkTo(parent.start, margin = 8.dp)
                            bottom.linkTo(parent.bottom, margin = 8.dp)
                        }
                        .zIndex(1f)
                        .background(
                            color = Glass,
                            shape = MaterialTheme.shapes.extraLarge
                        ),
                    horizontalArrangement = Arrangement.SpaceAround,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Spacer(modifier = Modifier.padding(start = 4.dp))
                    Icon(
                        modifier = Modifier
                            .size(12.dp),
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star",
                        tint = MaterialTheme.colorScheme.primary
                    )

                    Spacer(modifier = Modifier.padding(start = 4.dp))

                    Text(
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.bodySmall,
                        text = course.rate
                    )
                    Spacer(modifier = Modifier.padding(start = 8.dp))
                }

                Box(
                    modifier = Modifier
                        .height(22.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .hazeSource(hazeState, zIndex = 1f)
                        .hazeEffect(hazeState)
                        .constrainAs(date) {
                            start.linkTo(rate.end, margin = 8.dp)
                            bottom.linkTo(parent.bottom, margin = 8.dp)
                        }
                        .background(Glass, shape = MaterialTheme.shapes.extraLarge)
                        ,
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        modifier = Modifier.padding(horizontal = 8.dp),
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.bodySmall,
                        text = course.startDate
                    )
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxWidth(1f),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Column(
                    modifier = Modifier.fillMaxWidth(0.95f),
                    horizontalAlignment = Alignment.Start
                ) {
                    Text(
                        modifier = Modifier.padding(top = 8.dp),
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.titleMedium,
                        text = course.title
                    )

                    Text(
                        modifier = Modifier.padding(top = 8.dp, end = 8.dp),
                        color = MaterialTheme.colorScheme.secondary,
                        style = MaterialTheme.typography.bodySmall,
                        maxLines = 2,
                        text = course.text
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(1f),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            color = MaterialTheme.colorScheme.secondary,
                            text = "${course.price} ₽"
                        )

                        Text(
                            modifier = Modifier.padding(end = 16.dp),
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.bodySmall,
                            text = "Подробнее →"
                        )
                    }
                    Spacer(modifier = Modifier.padding(8.dp))
                }
            }
        }
    }

}


@Preview(device = "spec:width=1080px,height=2422px")
@Composable
fun previewCourseView() {
    AppCourseTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.padding(16.dp))
            CourseView(mockCourse(), {_, _ -> })
        }
    }
}