package learning.communication

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform