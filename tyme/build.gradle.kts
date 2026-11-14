import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidMultiplatformLibrary)
    alias(libs.plugins.androidLint)

    alias(libs.plugins.composeMultiplatform)
    alias(libs.plugins.composeCompiler)

    id("com.vanniktech.maven.publish") version "0.37.0" // 使用最新稳定版
}

kotlin {

    android {
        namespace = "com.tyme"
        compileSdk {
            version = release(37){
                minorApiLevel = 1 // 指定次要 API 级别为 1，即 37.1
            }
        }
        minSdk = 24

        // 从 Android Gradle 插件版本 8.8.0 开始
        // 必须显式开启，否则 androidMain/res 被忽略
        androidResources {
            enable = true
        }

        compilerOptions {
            jvmTarget = JvmTarget.JVM_11
        }

        withHostTestBuilder {}

        withDeviceTestBuilder { sourceSetTreeName = "test" }.configure {
            instrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        }
    }

    listOf(
//        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "tymeKit"
            isStatic = true
        }
    }

    jvm("desktop") {
        compilerOptions {
            jvmTarget.set(JvmTarget.JVM_11)
        }
    }

    js {
        browser()
        binaries.executable()
    }

    @OptIn(ExperimentalWasmDsl::class)
    wasmJs {
        browser()
        binaries.executable()
    }

    sourceSets {
        commonMain {
            dependencies {
                implementation(libs.kotlin.stdlib)
                // Add KMP dependencies here
                implementation(libs.compose.runtime)

                // KotlinX 多平台日期/时间库
                api("org.jetbrains.kotlinx:kotlinx-datetime:0.8.0")
            }
        }

        commonTest {
            dependencies {
                implementation(libs.kotlin.test)
            }
        }

        androidMain {
            dependencies {
                // Add Android-specific dependencies here. Note that this source set depends on
                // commonMain by default and will correctly pull the Android artifacts of any KMP
                // dependencies declared in commonMain.
            }
        }

        getByName("androidDeviceTest") {
            dependencies {
                implementation(libs.androidx.core)
                implementation(libs.androidx.testExt.junit)
                implementation(libs.androidx.testRunner)
            }
        }

        iosMain {
            dependencies {
                // Add iOS-specific dependencies here. This a source set created by Kotlin Gradle
                // Plugin (KGP) that each specific iOS target (e.g., iosX64) depends on as
                // part of KMP’s default source set hierarchy. Note that this source set depends
                // on common by default and will correctly pull the iOS artifacts of any
                // KMP dependencies declared in commonMain.
            }
        }
    }

}

dependencies {
    androidRuntimeClasspath(libs.compose.uiTooling)
}

mavenPublishing {
    // 指向 Central Portal（不是旧的 OSSRH）
    publishToMavenCentral()

    // 自动签名所有 publication
    signAllPublications()

    coordinates(
        groupId = "io.github.dxycw",
        artifactId = "tyme",
        version = "1.0.0" // 从 gradle.properties 或版本目录读取更佳
    )

    pom {
        name.set("tyme")
        description.set("一款强大的Kotlin多平台“tyme”日历工具库，适用于 Compose Multiplatform 的 Kotlin 多平台项目。Tyme是一个非常强大的日历工具库（可以看作 6tail的Tyme的升级版），拥有更优的设计和扩展性，支持公历、农历、藏历、回历、星座、干支、生肖、节气、月相、法定假日等。")
        url.set("https://github.com/dxycw/tyme")

        licenses {
            license {
                name.set("Apache-2.0")
                url.set("https://www.apache.org/licenses/LICENSE-2.0")
            }
        }
        developers {
            developer {
                id.set("dxycw")
                name.set("tyme")
                email.set("3293666408@qq.com")
            }
        }
        scm {
            connection.set("scm:git:git://github.com/dxycw/tyme.git")
            developerConnection.set("scm:git:ssh://github.com/dxycw/tyme.git")
            url.set("https://github.com/dxycw/tyme")
        }
    }
}