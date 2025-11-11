package com.permis.permisdeconduiremaroc

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform