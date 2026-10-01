pluginManagement {
    repositories {
        // NeoForge and Minecraft Forge repositories
        maven("https://maven.neoforged.net/") {
            name = "NeoForged"
        }
        maven("https://maven.minecraftforge.net/") {
            name = "MinecraftForge"
        }

        // Gradle Plugin Portal
        gradlePluginPortal()

        // Maven Central mirrors
        maven("https://maven.aliyun.com/repository/public") {
            name = "Aliyun"
        }
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        // NeoForge and Minecraft Forge (MUST come first)
        maven("https://maven.neoforged.net/") {
            name = "NeoForged"
        }
        maven("https://maven.minecraftforge.net/") {
            name = "MinecraftForge"
        }

        // Maven Central and mirrors
        maven("https://maven.aliyun.com/repository/public") {
            name = "Aliyun Public"
        }

        maven("https://repo.maven.apache.org/maven2/") {
            name = "Maven Central"
        }

        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version ("1.0.0")
}

rootProject.name = "ultraoptimize"

// annotation-processor requires unavailable mergetool artifact, skipping for now
// include("annotation-processor")
include("annotations")
