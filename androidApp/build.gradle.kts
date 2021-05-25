plugins {
    id("com.android.application")
    id("kotlin-android-extensions")
    kotlin("android")
}

dependencies {
    implementation(project(":shared"))
    implementation("com.google.android.material:material:1.3.0")
    implementation("androidx.appcompat:appcompat:1.3.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.4")
    implementation("com.github.bumptech.glide:glide:4.11.0")
    implementation("dev.icerock.moko:mvvm:0.10.1")
    annotationProcessor ("com.github.bumptech.glide:compiler:4.12.0")
}

android {
    compileSdkVersion(30)
    defaultConfig {
        applicationId = "com.example.newsappkmm.android"
        minSdkVersion(21)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}