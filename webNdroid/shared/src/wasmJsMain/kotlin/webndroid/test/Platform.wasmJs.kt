package webndroid.test

class WasmPlatform: Platform {
    override val name: String = "Web with Kotlin/Wasm"
}

actual fun getPlatform(): Platform = WasmPlatform()
actual fun getScreenWidth(): Int {
    TODO("Not yet implemented")
}

actual fun getScreenHeight(): Int {
    TODO("Not yet implemented")
}