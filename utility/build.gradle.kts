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

    // Core
    api("androidx.core:core-ktx:${Versions.androidCoreVersion}")

    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:${Versions.firebaseVersion}"))
    implementation("com.google.firebase:firebase-crashlytics")

    // Kotlin
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}")

    // Other
    api("com.jakewharton.timber:timber:${Versions.timberVersion}")

    // Test
    testApi("org.junit.jupiter:junit-jupiter-api:${Versions.junit5Version}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Versions.junit5Version}")
    testApi("io.mockk:mockk:${Versions.mockkVersion}")
    testApi("io.kotest:kotest-assertions-core:${Versions.kotestVersion}")
    testApi("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}")
    testApi("androidx.arch.core:core-testing:${Versions.coreTestingVersion}")
    testApi("app.cash.turbine:turbine:${Versions.turbineVersion}")

    // Detekt
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:${Versions.detektVersion}")
}
