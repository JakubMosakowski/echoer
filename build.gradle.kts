buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Classpaths.gradle)
        classpath(Classpaths.hilt)
        classpath(Classpaths.crashlytics)
        classpath(Classpaths.googlePlayServices)
        classpath(Classpaths.junit)
        classpath(Classpaths.kotlin)
    }
}

plugins {
    id("org.jetbrains.kotlinx.kover") version Versions.koverVersion
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
