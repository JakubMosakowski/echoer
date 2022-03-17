buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    id("org.jetbrains.kotlinx.kover") version Versions.koverVersion
    id("io.gitlab.arturbosch.detekt") version Versions.detektVersion
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
    apply {
        from("$rootDir/detekt/detekt.gradle")
    }

    dependencies {

        // Detekt
        detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:${Versions.detektVersion}")
    }
}
