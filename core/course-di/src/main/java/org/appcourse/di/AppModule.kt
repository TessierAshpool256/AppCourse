package org.appcourse.di

import dagger.BindsInstance
import dagger.Component
import org.appcourse.navigation_impl.Navigate
import javax.inject.Singleton


@Singleton
@Component(modules = [NetModule::class, CourseModule::class])
interface AppComponent {
    @Component.Factory
    interface Factory {
        fun create(@BindsInstance navigate: Navigate): AppComponent
    }
}
