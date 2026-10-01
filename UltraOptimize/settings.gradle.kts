pluginManagement {
    repositories {
        // NeoForge plugin portal
        maven("https://maven.neoforged.net/releases") {
            name = "NeoForged Releases"
        }

        // Gradle Plugin Portal
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
    repositoriesMode.set(RepositoriesMode.PREFER_SETTINGS)
    repositories {
        // NeoForge repositories (MUST come first for Forge artifacts)
        maven("https://maven.neoforged.net/releases") {
            name = "NeoForged Releases"
        }
        maven("https://maven.minecraftforge.net") {
            name = "MinecraftForge"
        }

        // Primary: Fast Chinese mirror for international access
        maven("https://maven.aliyun.com/repository/public") {
            name = "Aliyun Public"
        }

        // Secondary: European mirror
        maven("https://repo.eclipse.org/content/repositories/maven_central/") {
            name = "Eclipse Maven"
        }

        // Fallback mirrors
        maven("https://mirrors.tuna.tsinghua.edu.cn/maven/central") {
            name = "Tsinghua"
        }

        maven("https://repo.huaweicloud.com/repository/maven") {
            name = "Huawei Cloud"
        }

        // Last resort: Direct Maven Central
        maven("https://repo.maven.apache.org/maven2/") {
            name = "Maven Central Direct"
        }

        gradlePluginPortal()
        mavenCentral()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version ("1.0.0")
}

rootProject.name = "ultraoptimize"

include("annotation-processor")
include("annotations")
