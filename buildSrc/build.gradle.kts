plugins {
    `kotlin-dsl`
    `kotlin-dsl-precompiled-script-plugins`
}

repositories {
    google()
    mavenCentral()
}

dependencies {
    implementation("com.android.tools.build:gradle:${BuildSrcVersions.gradleVersion}")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:${BuildSrcVersions.kotlinVersion}")
}

object BuildSrcVersions {
    const val gradleVersion = "7.1.2"
    const val kotlinVersion = "1.6.10"
}
