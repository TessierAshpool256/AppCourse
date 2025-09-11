package org.appcourse.di

import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [NetModule::class, CourseModule::class])
interface AppComponent
