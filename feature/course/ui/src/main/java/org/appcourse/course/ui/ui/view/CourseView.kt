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
import androidx.compose.foundation.layout.wrapContentSize
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
import org.appcourse.course.entity.CourseEntity
import org.appcourse.course.ui.utile.mockCourse
import org.appcourse.course.ui.utile.mockImageByCourseId
import org.appcourse.course_list.R
import org.appcourse.ui_theme.AppCourseTheme
import org.appcourse.ui_theme.Glass


@Composable
fun CourseImageView(
    course: CourseEntity,
    toggleFavorite: ((Long, Boolean)-> Unit)
) {
    val hazeState = rememberHazeState()

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
                .clip(RoundedCornerShape(1f))
                .clickable { toggleFavorite(course.id, !course.hasLike) }
//                .hazeSource(hazeState, zIndex = 1f)
//                .hazeEffect(hazeState)
                .size(28.dp)
                .background(Glass, shape = CircleShape)
                .constrainAs(bookmark) {
                    top.linkTo(parent.top, margin = 8.dp)
                    end.linkTo(parent.end, margin = 8.dp)
                }
                .aspectRatio(1f)
                .padding(5.dp)
            ,
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                ,
                painter = painterResource(
                    if (course.hasLike)
                        R.drawable.ic_bookmark_fill
                    else
                        R.drawable.ic_bookmark
                ),
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
                )
                .padding(horizontal = 8.dp)
            ,
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                modifier = Modifier
                    .padding(end = 4.dp)
                    .size(12.dp),
                imageVector = Icons.Default.Star,
                contentDescription = "Star",
                tint = MaterialTheme.colorScheme.primary
            )
            Text(
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.bodySmall,
                text = course.rate
            )
        }

        Text(
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
                .padding(horizontal = 8.dp)
                .wrapContentSize()
            ,
            color = MaterialTheme.colorScheme.secondary,
            style = MaterialTheme.typography.bodySmall,
            text = course.startDate
        )
    }
}

@Composable
fun CourseView(
    course: CourseEntity,
    toggleFavorite: ((Long, Boolean)-> Unit),
) {
    Column(
        modifier = Modifier
            .fillMaxWidth(fraction = 0.9f)
            .clip(shape = MaterialTheme.shapes.medium)
            .background(color = MaterialTheme.colorScheme.tertiary)
        ,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        CourseImageView(
            course = course,
            toggleFavorite = toggleFavorite
        )

        Column(
            modifier = Modifier
                .fillMaxWidth(fraction = 0.95f),
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
                    .padding(top = 4.dp, bottom = 8.dp)
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
