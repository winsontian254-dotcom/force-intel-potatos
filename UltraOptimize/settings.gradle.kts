pluginManagement {
    repositories {
        // Try Gradle Plugin Portal first (usually faster and has mirrors)
        gradlePluginPortal()

        // Add Maven Central mirrors and alternatives
        maven("https://maven.aliyun.com/repository/public") {
            name = "Aliyun"
        }
        maven("https://repo1.maven.org/maven2") {
            name = "Maven Central Mirror"
        }
        maven("https://repo.maven.apache.org/maven2") {
            name = "Maven Central"
        }
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        // Try fastest mirrors first
        maven("https://maven.aliyun.com/repository/public") {
            name = "Aliyun"
        }
        maven("https://repo1.maven.org/maven2") {
            name = "Maven Central Mirror"
        }
        maven("https://repo.maven.apache.org/maven2") {
            name = "Maven Central"
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version ("1.0.0")
}

rootProject.name = "ultraoptimize"

include("annotation-processor")
include("annotations")
