package webndroid.test

class JVMPlatform: Platform {
    override val name: String = "Java ${System.getProperty("java.version")}"
}

actual fun getPlatform(): Platform = JVMPlatform()
actual fun getScreenWidth(): Int {
    TODO("Not yet implemented")

}

actual fun getScreenHeight(): Int {
    TODO("Not yet implemented")
}