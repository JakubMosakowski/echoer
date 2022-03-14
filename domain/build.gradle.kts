plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

android {

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = true
            proguardFiles(getDefaultProguardFile("proguard-android.txt"),
                rootProject.file("settings/proguard/proguard-rules.pro")
            )
        }
    }
    compileSdk = Versions.compileSdk

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    api(project(":data"))
    api(project(":utility"))

    // Hilt
    implementation("com.google.dagger:hilt-android:${Versions.hiltVersion}")

    // Detekt
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:${Versions.detektVersion}")
}

