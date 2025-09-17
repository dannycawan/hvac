plugins {
    id("com.android.application")
    id("kotlin-android")
    id("dev.flutter.flutter-gradle-plugin")
}

android {
    namespace = "com.hvac.fortworth"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.hvac.fortworth"   // ✅ perbaiki, tadi ada "com.com"
        minSdk = 21
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        release {
            // Untuk rilis jangan lupa signConfig nanti
            isMinifyEnabled = false
            shrinkResources = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        debug {
            isMinifyEnabled = false
        }
    }
}

flutter {
    source = "../.."
}
