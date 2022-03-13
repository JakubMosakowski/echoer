object Versions {
    const val androidCoreVersion = "1.7.0"
    const val composeActivityVersion = "1.4.0"
    const val composeHiltNavVersion = "1.0.0"
    const val composeNavVersion = "2.4.0"
    const val composeVersion = "1.1.1"
    const val coreTestingVersion = "2.1.0"
    const val coroutinesVersion = "1.6.0"
    const val crashlyticsGradleVersion = "2.8.0"
    const val firebaseVersion = "29.0.0"
    const val fragmentVersion = "1.3.6"
    const val googleServicesVersion = "4.3.10"
    const val gradleVersion = "7.1.2"
    const val hiltVersion = "2.40"
    const val junit5GradleVersion = "1.8.0.0"
    const val junit5Version = "5.8.2"
    const val kotestVersion = "4.6.3"
    const val kotlinVersion = "1.6.10"
    const val koverVersion = "0.5.0"
    const val mockkVersion = "1.12.0"
    const val moshiVersion = "1.13.0"
    const val okhttpLoggingInterceptorVersion = "4.9.3"
    const val orbitVersion = "4.2.0"
    const val retrofitVersion = "2.9.0"
    const val timberVersion = "5.0.1"
    const val turbineVersion = "0.7.0"
    const val compileSdk = 31
    const val minSdk = 24
    const val targetSdk = 31
}

object Classpaths {
    const val gradle = "com.android.tools.build:gradle:${Versions.gradleVersion}"
    const val hilt = "com.google.dagger:hilt-android-gradle-plugin:${Versions.hiltVersion}"
    const val crashlytics = "com.google.firebase:firebase-crashlytics-gradle:${Versions.crashlyticsGradleVersion}"
    const val googlePlayServices = "com.google.gms:google-services:${Versions.googleServicesVersion}"
    const val junit = "de.mannodermaus.gradle.plugins:android-junit5:${Versions.junit5GradleVersion}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlinVersion}"
}
