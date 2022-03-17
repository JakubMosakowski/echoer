plugins {
    id("com.android.library")
    id("kotlin-android")
    id("kotlin-kapt")
}

// TODO some methods here are marked incubating. Find out how to resolve that.
android {

    buildTypes {
        debug {
            isMinifyEnabled = false
        }
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android.txt"),
                rootProject.file("settings/proguard/proguard-rules.pro")
            )
        }
    }
    compileSdk = Versions.compileSdk

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
        freeCompilerArgs = freeCompilerArgs + listOf(
            "-Xuse-experimental=kotlinx.coroutines.ExperimentalCoroutinesApi",
        )
    }
}

dependencies {

    // Hilt
    implementation("com.google.dagger:hilt-android:${Versions.hiltVersion}")
    kapt("com.google.dagger:hilt-android-compiler:${Versions.hiltVersion}")
    kapt("com.google.dagger:hilt-compiler:${Versions.hiltVersion}")

    // Other
    api("com.jakewharton.timber:timber:${Versions.timberVersion}")

    // Test
    testApi("org.junit.jupiter:junit-jupiter-api:${Versions.junit5Version}")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:${Versions.junit5Version}")
    testApi("io.mockk:mockk:${Versions.mockkVersion}")
    testApi("io.kotest:kotest-assertions-core:${Versions.kotestVersion}")
    testApi("org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutinesVersion}")
    testApi("androidx.arch.core:core-testing:${Versions.coreTestingVersion}")
}
