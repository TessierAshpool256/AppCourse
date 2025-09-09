package org.appcourse.course_list.ui

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class CoursesViewModel @Inject constructor (
    private val courseRepository : CourseRepository
): ViewModel() {

}
