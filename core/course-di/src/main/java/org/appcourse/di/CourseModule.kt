package org.appcourse.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import org.appcourse.course.SystemNavigator
import org.appcourse.course.ui.repository.CourseRepository
import org.appcourse.data.CourseRepositoryImpl
import org.appcourse.utile.AndroidSystemNavigator
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class CourseModule {

    @Binds
    @Singleton
    abstract fun bindCourseRepository(
        impl: CourseRepositoryImpl
    ): CourseRepository

    @Binds
    abstract fun bindNavigator(
        impl: AndroidSystemNavigator
    ): SystemNavigator
}
