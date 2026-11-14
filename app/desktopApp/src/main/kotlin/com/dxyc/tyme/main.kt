package com.dxyc.tyme

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.tyme.solar.SolarDay
import java.time.LocalDate


fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Tymecs",
    ) {
        App()
//        Column {
////            // 公历
////            val solarDay = SolarDay.fromYmd(1986, 5, 29)
////
////            // 1986年5月29日
////            Text(text = solarDay.toString())
////
////            // 农历丙寅年四月廿一
////            Text(text = solarDay.getLunarDay().toString())
////
////            // 第十七饶迥火虎年四月廿一
////            Text(text = solarDay.getRabByungDay().toString())
////
////            // 1406年赖买丹月20日
////            Text(text = solarDay.getHijriDay().toString())
//
//            // 1. 获取今天的公历年月日
//            val today = LocalDate.now()
//
//            // 2. 构建 tyme4kt 的 SolarDay 对象
//            val solarDay = SolarDay.fromYmd(today.year, today.monthValue, today.dayOfMonth)
//
//            // 3. 打印，或继续调用 tyme4kt 的其他API
//            Text(text = solarDay.toString()) // 输出格式类似：2026年11月14日
//            Text(text = solarDay.getLunarDay().toString()) // 同时获取对应的农历日
//            Text(text = solarDay.getRabByungDay().toString())
//            Text(text = solarDay.getHijriDay().toString())
//        }
    }
}