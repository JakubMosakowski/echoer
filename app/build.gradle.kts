import java.io.File
import java.io.FileInputStream
import java.util.Properties

plugins {
    id("com.android.application")
    id("com.google.gms.google-services")
    id("com.google.firebase.crashlytics")
    id("kotlin-android")
    id("kotlin-kapt")
    id("kotlin-parcelize")
    id("dagger.hilt.android.plugin")
    id("de.mannodermaus.android-junit5")
}

android {

    defaultConfig {
        applicationId = "com.jakmos.echoer"
        compileSdk = Versions.compileSdk
        minSdk = Versions.minSdk
        targetSdk = Versions.targetSdk
        versionCode = 1
        versionName = "0.0.1"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    val keystoreProperties = Properties().apply {
        load(FileInputStream(File(rootProject.rootDir, "settings/keystore/keystore.properties")))
    }

    signingConfigs {
        named("debug") {
            keyAlias = "androiddebugkey"
            keyPassword = "android"
            storePassword = "android"
            storeFile = rootProject.file("settings/keystore/debug.jks")
        }
        create("release") {
            keyAlias = keystoreProperties.getProperty("keyAlias")
            keyPassword = keystoreProperties.getProperty("keyPassword")
            storePassword = keystoreProperties.getProperty("storePassword")
            storeFile = rootProject.file("settings/keystore/release.jks")
        }
    }

    buildTypes {
        debug {
            isMinifyEnabled = false
            signingConfig = signingConfigs.getByName("debug")

            resValue("string", "app_name", "Echoer Development")
            applicationIdSuffix = ".dev"
            versionNameSuffix =" Development"

            buildConfigField("String", "SERVER_LOGGING_LEVEL", "\"BODY\"")
            buildConfigField("Boolean", "ENABLE_CRASHLYTICS", "false")
        }
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"),
                rootProject.file("settings/proguard/proguard-rules.pro")
            )
            signingConfig = signingConfigs.getByName("release")

            resValue("string", "app_name", "Echoer")

            buildConfigField("String", "SERVER_LOGGING_LEVEL", "\"NONE\"")
            buildConfigField("Boolean", "ENABLE_CRASHLYTICS", "true")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(project(":presentation"))
    implementation(project(":domain"))
    implementation(project(":data"))

    // Hilt
    implementation("com.google.dagger:hilt-android:${Versions.hiltVersion}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}")
    kapt("com.google.dagger:hilt-compiler:${Versions.hiltVersion}")
}
