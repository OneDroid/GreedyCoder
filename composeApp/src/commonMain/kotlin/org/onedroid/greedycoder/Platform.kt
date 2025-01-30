package org.onedroid.greedycoder

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform