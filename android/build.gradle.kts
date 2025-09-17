// Root build.gradle.kts

plugins {
    // Android Gradle Plugin versi stabil
    id("com.android.application") version "8.7.3" apply false

    // Kotlin versi stabil (disarankan Flutter stable)
    id("org.jetbrains.kotlin.android") version "1.9.24" apply false
}

// Repositori global
allprojects {
    repositories {
        google()
        mavenCentral()
    }
}
