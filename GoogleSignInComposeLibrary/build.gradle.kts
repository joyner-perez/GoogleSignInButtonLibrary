plugins {
    id ("com.android.library")
    id ("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.joyner.googlesignincomposelibrary"
    compileSdk = 34

    defaultConfig {
        minSdk = 24
        aarMetadata {
            minCompileSdk = 24
        }

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildFeatures {
        buildConfig = true
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
}

dependencies {
    implementation ("androidx.core:core-ktx:1.12.0")
    implementation (platform ("androidx.compose:compose-bom:2023.09.00"))
    implementation ("androidx.compose.material3:material3")
    implementation ("androidx.compose.ui:ui")
    implementation ("androidx.compose.ui:ui-tooling-preview")
    implementation ("androidx.activity:activity-compose:1.7.2")
    testImplementation ("junit:junit:4.13.2")
    androidTestImplementation ("androidx.compose.ui:ui-test-junit4")
    androidTestImplementation ("androidx.test.ext:junit:1.1.5")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.5.1")
    debugImplementation ("androidx.compose.ui:ui-test-manifest")
    debugImplementation ("androidx.compose.ui:ui-tooling")
}