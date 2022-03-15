plugins {
    id("echoer-library")
    id("dagger.hilt.android.plugin")
}

dependencies {

    api(project(":domain"))

    // Firebase
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth")
    implementation("com.google.firebase:firebase-messaging-ktx")

    // Kotlin
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:${Versions.coroutinesVersion}")

    // Moshi
    implementation("com.squareup.moshi:moshi:${Versions.moshiVersion}")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:${Versions.moshiVersion}")

    // Retrofit
    implementation("com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}")
    implementation("com.squareup.retrofit2:converter-moshi:${Versions.retrofitVersion}")
    implementation("com.squareup.okhttp3:logging-interceptor:${Versions.okhttpLoggingInterceptorVersion}")

    // Detekt
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:${Versions.detektVersion}")
}
