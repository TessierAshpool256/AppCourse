package org.appcourse.course.usecase

import org.appcourse.course.Action
import org.appcourse.course.SystemNavigator
import javax.inject.Inject

class GoToMediaUseCase @Inject constructor(
    private val navigator: SystemNavigator
) {
    operator fun invoke(url: String) {
        navigator.navigate(Action.OpenWebPage(url))
    }
}