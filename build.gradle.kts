buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath(Classpaths.gradle)
        classpath(Classpaths.hilt)
        classpath(Classpaths.crashlytics)
        classpath(Classpaths.googlePlayServices)
        classpath(Classpaths.junit)
        classpath(Classpaths.kotlin)
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
