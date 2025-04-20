package web.and.android

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform