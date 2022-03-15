plugins {
    id("echoer-library")
    id("dagger.hilt.android.plugin")
}

dependencies {

    api(project(":utility"))

    // Detekt
    detektPlugins("io.gitlab.arturbosch.detekt:detekt-formatting:${Versions.detektVersion}")
}

