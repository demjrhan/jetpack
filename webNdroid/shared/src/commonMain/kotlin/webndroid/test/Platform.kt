package webndroid.test

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
expect fun getScreenWidth() : Int
expect fun getScreenHeight() : Int