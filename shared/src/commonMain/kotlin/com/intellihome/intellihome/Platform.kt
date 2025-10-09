package com.intellihome.intellihome

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform