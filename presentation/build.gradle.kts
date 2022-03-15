plugins {
    id("echoer-library")
    id("dagger.hilt.android.plugin")
}

android {

    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = Versions.composeVersion
    }
}

dependencies {

    implementation(project(":domain"))

    // Compose
    implementation("androidx.compose.ui:ui:${Versions.composeVersion}")
    implementation("androidx.compose.material:material:${Versions.composeVersion}")
    implementation("androidx.compose.material:material-icons-extended:${Versions.composeVersion}")
    implementation("androidx.compose.ui:ui-tooling-preview:${Versions.composeVersion}")
    implementation("androidx.activity:activity-compose:${Versions.composeActivityVersion}")
    implementation("androidx.navigation:navigation-compose:${Versions.composeNavVersion}")
    implementation("androidx.hilt:hilt-navigation-compose:${Versions.composeHiltNavVersion}")
    debugImplementation("androidx.compose.ui:ui-tooling:${Versions.composeVersion}")

    // Orbit
    implementation("org.orbit-mvi:orbit-viewmodel:${Versions.orbitVersion}")
}
