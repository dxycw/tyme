package com.dxyc.tyme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.tyme.solar.SolarDay
import kotlinx.datetime.LocalTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.format.DateTimeComponents
import kotlinx.datetime.todayIn
import org.jetbrains.compose.resources.painterResource

import tymecs.app.shared.generated.resources.Res
import tymecs.app.shared.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
        var showContent by remember { mutableStateOf(false) }
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .safeContentPadding()
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(onClick = { showContent = !showContent }) {
                Text("点击我！")
            }

            Text(
                getTodaySolarDay().toString()
            )

            val time = DateTimeComponents.Format { time(LocalTime.Formats.ISO) }
                .parse("23:59:60").apply {
                    if (second == 60) second = 59
                }.toLocalTime()
            Text(
                time.toString() // 23:59:59
            )

            AnimatedVisibility(showContent) {
                val greeting = remember { Greeting().greet() }
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}

fun getTodaySolarDay(): SolarDay {
    // 1. 用 kotlinx-datetime 获取当前时区的“今天”
    val today = kotlin.time.Clock.System.todayIn(TimeZone.currentSystemDefault())

    // 2. 交给 tyme4kt 构建 SolarDay
    return SolarDay.fromYmd(
        year = today.year,
        month = today.monthNumber, // 注意：kotlinx-datetime 用 monthNumber
        day = today.dayOfMonth
    )
}