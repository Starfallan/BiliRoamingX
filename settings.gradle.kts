@file:Suppress("UnstableApiUsage")

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        mavenLocal()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositoriesMode = RepositoriesMode.FAIL_ON_PROJECT_REPOS
    val gprUser = settings.providers.gradleProperty("gpr.user")
    val gprKey = settings.providers.gradleProperty("gpr.key")
    repositories {
        mavenCentral()
        mavenLocal()
        google()
        maven { url = uri("https://jitpack.io") }
        maven {
            // Primary repository for custom revanced packages
            url = uri("https://maven.pkg.github.com/zjns/registry")
            credentials {
                username = gprUser.orNull ?: System.getenv("GITHUB_ACTOR")
                password = gprKey.orNull ?: System.getenv("GITHUB_TOKEN")
            }
        }
        maven {
            // Fallback: revanced-patcher specific repository
            url = uri("https://maven.pkg.github.com/zjns/revanced-patcher")
            credentials {
                username = gprUser.orNull ?: System.getenv("GITHUB_ACTOR")
                password = gprKey.orNull ?: System.getenv("GITHUB_TOKEN")
            }
        }
        maven {
            // Fallback: apktool-lib specific repository
            url = uri("https://maven.pkg.github.com/zjns/apktool-lib")
            credentials {
                username = gprUser.orNull ?: System.getenv("GITHUB_ACTOR")
                password = gprKey.orNull ?: System.getenv("GITHUB_TOKEN")
            }
        }
        maven {
            // Fallback: BiliRoamingX main project repository
            url = uri("https://maven.pkg.github.com/BiliRoamingX/BiliRoamingX")
            credentials {
                username = gprUser.orNull ?: System.getenv("GITHUB_ACTOR")
                password = gprKey.orNull ?: System.getenv("GITHUB_TOKEN")
            }
        }
        maven {
            // Fallback: Fork repository (current fork)
            url = uri("https://maven.pkg.github.com/Starfallan/BiliRoamingX")
            credentials {
                username = gprUser.orNull ?: System.getenv("GITHUB_ACTOR")
                password = gprKey.orNull ?: System.getenv("GITHUB_TOKEN")
            }
        }
        maven {
            // Fallback: zjns's BiliRoamingX repository
            url = uri("https://maven.pkg.github.com/zjns/BiliRoamingX")
            credentials {
                username = gprUser.orNull ?: System.getenv("GITHUB_ACTOR")
                password = gprKey.orNull ?: System.getenv("GITHUB_TOKEN")
            }
        }
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}

include(
    ":integrations:app",
    ":integrations:dummy",
    ":integrations:extend",
    ":integrations:ksp",
    ":integrations",
    ":patches"
)
rootProject.name = "BiliRoamingX"
