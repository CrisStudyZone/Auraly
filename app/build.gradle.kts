import io.gitlab.arturbosch.detekt.Detekt

plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.daggerHiltAndroid)
    alias(libs.plugins.ktlint)
    alias(libs.plugins.kover)
    alias(libs.plugins.detekt)
    alias(libs.plugins.kotlin.compose.compiler)
    alias(libs.plugins.google.services)
}

android {
    namespace = "com.serdigital.auraly"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.serdigital.auraly"
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
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    ktlint {
        android.set(true)
    }
    detekt {
        toolVersion = "1.22.0"
        parallel = true
        buildUponDefaultConfig = true
        allRules = true
        ignoreFailures = false
        config = files("C:\\Users\\54116\\AndroidStudioProjects\\Auraly\\detekt.yml")
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
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)

    // Dagger + Hilt
    implementation(libs.daggerHiltAndroid)
    ksp(libs.daggerHiltAndroidCompiler)
    implementation(libs.daggerHiltAndroidTesting)
    implementation(libs.androidxHiltNavigationCompose)
    androidTestImplementation(libs.daggerHiltAndroidTesting)
    testImplementation(libs.daggerHiltAndroidTesting)

    // Firebase
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.database)
}

tasks.withType<Detekt>().configureEach {
    jvmTarget = "1.8"
}
