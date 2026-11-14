> [!CAUTION]
>
> **注意：本库是本作者个人私库（不公开分享本库，不建议他人使用），如果想使用本库可以在项目中使用依赖库或克隆分支（可以自己新建一个分支修改本库，不可提交到本库），请不要上传提交，请勿私自外传本项目。**


<div align="center">

<h1>
  Compose Multiplatform Tyme
</h1>

**一款强大的Kotlin多平台“tyme”日历工具库，适用于 Compose Multiplatform 的 Kotlin 多平台项目。Tyme是一个非常强大的日历工具库，可以看作 [6tail的Tyme](https://github.com/6tail/tyme4kt "https://github.com/6tail/tyme4kt") 的升级版，拥有更优的设计和扩展性，支持公历、农历、藏历、回历、星座、干支、生肖、节气、月相、法定假日等。**

[![License](https://img.shields.io/badge/license-MIT-4EB1BA.svg?style=flat-square)](https://github.com/6tail/tyme4kt/blob/master/LICENSE)
[![Maven Central](https://img.shields.io/maven-central/v/io.github.dxycw/tyme?label=Maven%20Central&color=orange)](https://central.sonatype.com/artifact/io.github.dxycw/tyme)
[![Kotlin](https://img.shields.io/badge/kotlin-v2.4.21-blue.svg?logo=kotlin)](http://kotlinlang.org)
[![Compose Multiplatform](https://img.shields.io/badge/Compose%20Multiplatform-v1.12.2-blue)](https://github.com/JetBrains/compose-multiplatform)

![badge-android](http://img.shields.io/badge/platform-android-6EDB8D.svg?style=flat)
![badge-ios](http://img.shields.io/badge/platform-ios-CDCDCD.svg?style=flat)
![badge-desktop](http://img.shields.io/badge/platform-desktop-DB413D.svg?style=flat)
![badge-web](https://img.shields.io/badge/platform-web-59B6EC.svg?style=flat)

</div>

# Multiplatform平台所有使用的依赖库：

| 依赖库                                 | 描述                      | 版本                                                                               | 项目更新版本 | 是否公开api |
|----------------------------------------|---------------------------|------------------------------------------------------------------------------------|--------------|-------------|
| org.jetbrains.kotlinx:kotlinx-datetime | KotlinX 多平台日期/时间库 | [0.8.0](https://mvnrepository.com/artifact/org.jetbrains.kotlinx/kotlinx-datetime) | 1.0.0        | 是          |


### Gradle

```
// build.gradle.kts
dependencies {
    implementation("io.github.dxycw:tyme:1.0.0")
}

```

## 示例

    import com.tyme.solar.SolarDay
     
    fun main() {
        // 公历
        val solarDay = SolarDay.fromYmd(1986, 5, 29)
         
        // 1986年5月29日
        println(solarDay)
         
        // 农历丙寅年四月廿一
        println(solarDay.getLunarDay())
         
        // 第十七饶迥火虎年四月廿一
        println(solarDay.getRabByungDay())

        // 1406年赖买丹月20日
        println(solarDay.getHijriDay())
    }


## 文档

请移步至 [https://6tail.cn/tyme.html](https://6tail.cn/tyme.html "https://6tail.cn/tyme.html")


## 更新日志

### 1.0.0

* 发布到 Maven Central 仓库；
* 优化 项目文档，完善使用方法、平台支持、依赖库等信息；
* 添加 对Web平台的Js平台支持；
* 添加 org.jetbrains.kotlinx:kotlinx-datetime 依赖库的版本为 0.8.0；
* 更新 Gradle 版本为 9.8.2；
* 更新 AGP 版本为 9.5.1；
* 更新 Kotlin 版本为 2.4.21；
* 更新 Compose Multiplatform 版本为 1.12.2；
* 更新 Material3 版本为 1.12.0-alpha03；
* 更新 kotlin-wrappers 版本为 2026.11.0；
* 更新 ktor 版本为 3.6.1；
