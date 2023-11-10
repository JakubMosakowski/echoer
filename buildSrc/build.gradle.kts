plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
}

dependencies {

    // Classpaths
    implementation("com.android.tools.build:gradle:${BuildSrcVersions.gradleVersion}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${BuildSrcVersions.kotlinVersion}")
    implementation("com.google.dagger:hilt-android-gradle-plugin:${BuildSrcVersions.hiltVersion}")
    implementation("com.google.firebase:firebase-crashlytics-gradle:${BuildSrcVersions.crashlyticsGradleVersion}")
    implementation("com.google.gms:google-services:${BuildSrcVersions.googleServicesVersion}")
    implementation("de.mannodermaus.gradle.plugins:android-junit5:${BuildSrcVersions.junit5GradleVersion}")
}

object BuildSrcVersions {
    const val crashlyticsGradleVersion = "2.8.0"
    const val googleServicesVersion = "4.3.10"
    const val gradleVersion = "7.1.2"
    const val hiltVersion = "2.40"
    const val junit5GradleVersion = "1.8.2.0"
    const val kotlinVersion = "1.6.10"
}
