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
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
    }
}

rootProject.name = "AppCourse"
include(":app")

include(":core:navigation-api")
include(":core:navigation-impl")
include(":core:course-api")
include(":core:course-di")
include(":core:course-db")
include(":core:course-data")
include(":core:ui-theme")
include(":core:utile")

include(":feature:auth:ui")
include(":feature:auth:domain")

include(":feature:course:ui")
include(":feature:course:domain")
