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

    api(project(":utility"))

    // Firebase
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-messaging-ktx")

    // Kotlin
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutinesVersion}")

    // Hilt
    implementation("com.google.dagger:hilt-android:${Versions.hiltVersion}")

    // Moshi
    implementation("com.squareup.moshi:moshi:${Versions.moshiVersion}")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}")
    implementation("com.squareup.retrofit2:converter-moshi:${Versions.retrofitVersion}")
    implementation("com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLoggingInterceptorVersion}")
}
