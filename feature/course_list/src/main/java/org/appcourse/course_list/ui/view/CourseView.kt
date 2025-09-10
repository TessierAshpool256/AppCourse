package org.appcourse.course_list.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import org.appcourse.course_list.models.CourseEntity
import org.appcourse.course_list.utile.mockImageByCourseId
import org.appcourse.ui_theme.AppCourseTheme


@Composable
fun CourseView(
    course: CourseEntity
) {
    Box(
        modifier = Modifier
            .clip(MaterialTheme.shapes.extraLarge)
            .background(MaterialTheme.colorScheme.tertiary)
            .fillMaxWidth(.9f),
    ) {
        ConstraintLayout(

        ) {
            val (rate, date, image, bookmark) = createRefs()
            Image(
                modifier = Modifier
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
        }

        Column {
            Text(
                color = MaterialTheme.colorScheme.secondary,
                style = MaterialTheme.typography.titleMedium,
                text = course.title
            )

            Text(
                course.text
            )

            Row(
                modifier = Modifier.fillMaxWidth(1f),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier.padding(start = 16.dp),
                    text = course.price
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


@Preview(device = "spec:width=1080px,height=2422px")
@Composable
fun previewCourseView() {
    val course = CourseEntity(
            100,
            "Java-разработчик с нуля",
            "Освойте backend-разработку и программирование на Java, фреймворки Spring и Maven, работу с базами данных и API. Создайте свой собственный проект, собрав портфолио и став востребованным специалистом для любой IT компании.",
            "999",
            "4.9",
            "2024-05-22",
            false,
            "2024-02-02"
    )
    AppCourseTheme {
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            CourseView(course)
        }
    }
}