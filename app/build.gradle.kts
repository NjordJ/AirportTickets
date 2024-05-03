plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.irudaru.airporttickets"
    compileSdk = 34

//    sourceSets {
//        sourceSets.getByName("main") {
//            java.srcDirs("src/main/kotlin")
//            java.srcDirs("src/main/java")
//        }
//        sourceSets.getByName("test") {
//            java.srcDirs("src/test/kotlin")
//            java.srcDirs("src/test/java")
//        }
//    }
//
//    // For KSP
//    applicationVariants.configureEach {
//        sourceSets {
//            getByName(name) {
//                java.srcDirs("build/generated/ksp/${name}/kotlin")
//            }
//        }
//    }

    sourceSets {
        sourceSets.getByName("main") {
            java.srcDirs("build/generated/ksp/main/kotlin")
            java.srcDirs("build/generated/ksp/main/java")
        }

        sourceSets.getByName("test") {
            java.srcDirs("build/generated/ksp/test/kotlin")
            java.srcDirs("build/generated/ksp/test/java")
        }
    }

//    android.applicationVariants.all { variant ->
//        variant.addJavaSourceFoldersToModel(file("build/generated/ksp/${variant.name}/kotlin"))
//        variant.
//    }

    defaultConfig {
        applicationId = "com.irudaru.airporttickets"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "0.1.0"

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
        kotlinCompilerExtensionVersion = "1.5.7"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
    ksp {
        arg("KOIN_CONFIG_CHECK","true")
    }
}

dependencies {

    // Core
    implementation("androidx.core:core-ktx:1.13.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2024.04.01"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")

    // Architecture Components
    val lifecycle_version = "2.7.0"
    // ViewModel
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // ViewModel utilities for Compose
    implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
    // Lifecycles only (without ViewModel or LiveData)
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
    // Lifecycle utilities for Compose
    implementation ("androidx.lifecycle:lifecycle-runtime-compose:$lifecycle_version")


    // Local data
    val room_version = "2.6.1"
    implementation ("androidx.room:room-runtime:$room_version")
    implementation ("androidx.room:room-ktx:$room_version")
    annotationProcessor ("androidx.room:room-compiler:$room_version")
        // To use Kotlin Symbol Processing (KSP)
    ksp ("androidx.room:room-compiler:$room_version")

    // DI / Service locator
    val koin_version = "3.5.6"
    val koin_annotations = "1.3.1"
    implementation(platform("io.insert-koin:koin-bom:$koin_version"))
    implementation("io.insert-koin:koin-core:$koin_version")
    implementation("io.insert-koin:koin-android:$koin_version")
    implementation("io.insert-koin:koin-androidx-compose:$koin_version")
    implementation("io.insert-koin:koin-annotations:$koin_annotations")
    ksp ("io.insert-koin:koin-ksp-compiler:$koin_annotations")

    implementation ("javax.inject:javax.inject:1")

    // Concurrency
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.8.0")

    // Test
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2024.04.01"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}