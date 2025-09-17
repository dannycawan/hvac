pluginManagement {
    val flutterSdkPath = run {
        val properties = java.util.Properties()
        file("local.properties").inputStream().use { properties.load(it) }
        val flutterSdkPath = properties.getProperty("flutter.sdk")
        require(flutterSdkPath != null) { "flutter.sdk not set in local.properties" }
        flutterSdkPath
    }

    includeBuild("$flutterSdkPath/packages/flutter_tools/gradle")

    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}

plugins {
    // Loader wajib biar Flutter SDK dikenali
    id("dev.flutter.flutter-plugin-loader") version "1.0.0"

    // Android Gradle Plugin terbaru (sesuai Gradle 8.7+)
    id("com.android.application") version "8.7.3" apply false

    // Kotlin terbaru stabil
    id("org.jetbrains.kotlin.android") version "1.9.24" apply false
    // ⚠️ versi "2.1.0" masih experimental dan sering bikin crash di Flutter
}

include(":app")
