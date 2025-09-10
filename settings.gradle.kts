pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "AppCourse"
include(":app")

include(":core:navigation-api")
include(":core:course-api")
include(":core:course-di")
include(":core:course-db")
include(":core:course-data")

include(":feature:auth")
include(":feature:course_list")
include(":core:navigation-impl")
include(":core:ui-theme")
