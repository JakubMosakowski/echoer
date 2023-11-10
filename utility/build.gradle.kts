plugins {
    id("echoer-library")
    id("dagger.hilt.android.plugin")
}

dependencies {

    // Core
    api("androidx.core:core-ktx:${Versions.androidCoreVersion}")

    // Firebase
    implementation(platform("com.google.firebase:firebase-bom:${Versions.firebaseVersion}"))
    implementation("com.google.firebase:firebase-crashlytics")

    // Kotlin
    api("org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesVersion}")
}
