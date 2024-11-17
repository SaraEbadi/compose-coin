plugins {
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.android.application)
    alias(libs.plugins.compose.compiler)
    alias(libs.plugins.secrets.gradle)
    alias(libs.plugins.kotlin.kapt)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlin.serialization)
}

android {
    namespace = "com.composecoin.feature.marketlist"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.composecoin.feature.marketlist"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
}

dependencies {
    with(libs) {
        implementation(androidx.ui)
        implementation(androidx.core.ktx)
        implementation(androidx.material3)
        implementation(androidx.material3.adaptive)
        implementation(androidx.compose.material3.iconsExtended)
        implementation(androidx.compose.material3.navigationSuite)
        implementation(androidx.compose.material3.adaptive.navigation)
        implementation(compose.navigation)
        implementation(androidx.ui.graphics)
        implementation(androidx.activity.compose)
        implementation(androidx.ui.tooling.preview)
        implementation(androidx.lifecycle.runtime.ktx)
        implementation(platform(libs.androidx.compose.bom))

        kapt(hilt.compiler)
        implementation(coil)
        implementation(moshi)
        implementation(timber)
        implementation(hilt.compose)
        implementation(hilt.android)
        implementation(bundles.arrow)
        implementation(bundles.okhttp)
        implementation(bundles.retrofit)
        api(libs.retrofit.converter.gson)
        api(libs.gson)
        implementation(kotlin.immutable)
        implementation(kotlinx.serialization.json)

        debugImplementation(androidx.ui.tooling)
        debugImplementation(androidx.ui.test.manifest)

        testImplementation(junit)
        androidTestImplementation(androidx.junit)
        androidTestImplementation(androidx.espresso.core)
        androidTestImplementation(androidx.ui.test.junit4)
        androidTestImplementation(platform(libs.androidx.compose.bom))

        implementation(projects.domain.market)
    }

}