package org.appcourse.utile

import android.content.Context
import android.content.Intent
import androidx.core.net.toUri
import dagger.hilt.android.qualifiers.ApplicationContext
import org.appcourse.course.Action
import org.appcourse.course.SystemNavigator
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AndroidSystemNavigator @Inject constructor(
    @ApplicationContext private val appContext: Context
) : SystemNavigator {

    override fun navigate(action: Action) {
        when (action) {
            is Action.OpenWebPage -> {
                val uri = action.url.toUri()
                val intent = Intent(Intent.ACTION_VIEW, uri).apply {
                    addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                }
                appContext.startActivity(intent)
            }
        }
    }
}