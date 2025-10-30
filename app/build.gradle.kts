plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    id("com.google.dagger.hilt.android")
    id("com.google.devtools.ksp")
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0" apply false
    id("kotlin-parcelize")
}

android {
    namespace = "com.example.jetpackcopmmposecomponent"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.example.jetpackcopmmposecomponent"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.material3)
    implementation(libs.androidx.compose.material3)
    implementation(libs.androidx.palette.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    implementation(libs.androidx.compose.material.icons.extended)

    //Splash Api
    implementation(libs.androidx.core.splashscreen)

    //Compose Navigation
    implementation("androidx.navigation:navigation-compose:2.9.4")

    implementation("androidx.compose.material3.adaptive:adaptive:1.3.0-alpha01")
    implementation("androidx.compose.material3.adaptive:adaptive-layout:1.3.0-alpha01")
    implementation("androidx.compose.material3.adaptive:adaptive-navigation:1.3.0-alpha01")

    //Hilt
    implementation("com.google.dagger:hilt-android:2.51.1")
    ksp("com.google.dagger:hilt-android-compiler:2.51.1")
    ksp("com.google.dagger:hilt-compiler:2.51.1")
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    //Coil
    implementation("io.coil-kt:coil-compose:2.4.0")


    //Datastore
    implementation("androidx.datastore:datastore-preferences:1.0.0")

    //Compose Foundation
    implementation("androidx.compose.foundation:foundation:1.4.3")

    //Accompanist
    implementation("com.google.accompanist:accompanist-systemuicontroller:0.31.4-beta")

    //Paging 3
    implementation("androidx.paging:paging-runtime:3.1.1")
    implementation("androidx.paging:paging-compose:3.2.0-rc01")

    implementation("androidx.room:room-runtime:2.6.1")
    ksp("androidx.room:room-compiler:2.6.1")
    //DOES NOT WORK
    //kapt "androidx.room:room-compiler:$room_version"
    implementation("androidx.room:room-ktx:2.6.1")

    // Kotlin Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.0.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.0.0")

    // Retrofit for making HTTP calls
    implementation("com.squareup.retrofit2:retrofit:2.9.0")

// Moshi converter for parsing JSON responses
    implementation("com.squareup.retrofit2:converter-moshi:2.9.0")

// Moshi library for JSON parsing and serialization
    implementation("com.squareup.moshi:moshi-kotlin:1.13.0")

// Moshi adapters for common data types like Java 8 dates and times
    implementation("com.squareup.moshi:moshi-adapters:1.13.0")

// OkHttp for HTTP request/response handling
    implementation("com.squareup.okhttp3:okhttp:4.9.3")

// OkHttp logging interceptor for debugging HTTP traffic
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")

// Android Architecture Components for lifecycle management
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.4.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.4.0")

    implementation("com.google.accompanist:accompanist-pager:0.20.2")
    implementation("com.google.accompanist:accompanist-pager-indicators:0.20.2")
    implementation ("com.google.accompanist:accompanist-flowlayout:0.26.4-beta")

    // Navigator
    implementation ("cafe.adriel.voyager:voyager-navigator:1.0.1")

    // BottomSheetNavigator
    implementation ("cafe.adriel.voyager:voyager-bottom-sheet-navigator:1.1.0-beta03")

    // TabNavigator
    implementation ("cafe.adriel.voyager:voyager-tab-navigator:1.1.0-beta03")

    // Transitions
    implementation ("cafe.adriel.voyager:voyager-transitions:1.1.0-beta03")

    // Android ViewModel integration
    implementation ("cafe.adriel.voyager:voyager-androidx:1.0.0-rc10")

    // Hilt integration
    implementation ("cafe.adriel.voyager:voyager-hilt:1.1.0-beta03")

    //constraint layout
    implementation("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")

    //permission
    implementation("com.google.accompanist:accompanist-permissions:0.31.1-alpha")
    //lottie-animation
    implementation("com.airbnb.android:lottie-compose:6.6.10")
    //coil
    implementation("io.coil-kt:coil-compose:2.7.0")
    implementation("io.coil-kt:coil-gif:2.7.0")
    implementation("io.coil-kt:coil-svg:2.7.0")
    //ML kit Scanner
    implementation("com.google.android.gms:play-services-mlkit-document-scanner:16.0.0")

}