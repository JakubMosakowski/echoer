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
    id("io.gitlab.arturbosch.detekt") version Versions.detektVersion
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
    apply {
        from("$rootDir/detekt/detekt.gradle")
    }
}
