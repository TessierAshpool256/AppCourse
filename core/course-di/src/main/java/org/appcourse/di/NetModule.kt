package org.appcourse.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import org.appcourse.cours_api.courseApi
import org.appcourse.db.CourseDatabase
import org.appcourse.navigation.NavContract
import org.appcourse.navigation_impl.Navigate
import org.appcourse.navigation_impl.appBackStack
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetModule {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient =
        OkHttpClient.Builder()
            .build()

    @Provides
    @Singleton
    fun provideCourseApi(client: OkHttpClient) =
        courseApi(okHttpClient = client)

    @Provides
    @Singleton
    fun provideCourseDatabase(
        @ApplicationContext context: Context
    ): CourseDatabase {
        return CourseDatabase(context)
    }

    @Provides
    @Singleton
    fun provideNavContract() : NavContract {
        return Navigate(appBackStack())
    }

}
