package webndroid.test

import android.os.Build

class AndroidPlatform : Platform {
    override val name: String = "Android ${Build.VERSION.SDK_INT}"
}



actual fun getPlatform(): Platform = AndroidPlatform()
actual fun getScreenWidth(): Int {
    TODO("Not yet implemented")
}

actual fun getScreenHeight(): Int {
    TODO("Not yet implemented")
}