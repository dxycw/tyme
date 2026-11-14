package com.dxyc.tyme

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform