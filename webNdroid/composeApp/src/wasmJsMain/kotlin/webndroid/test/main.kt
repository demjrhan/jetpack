package webndroid.test

import App
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window

fun pxToDp(px: Double): Dp = (px / window.devicePixelRatio).dp

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    // Get the current viewport width and height in dp.
    val widthDp = pxToDp(window.innerWidth.toDouble())
    val heightDp = pxToDp(window.innerHeight.toDouble())

    ComposeViewport(document.body!!) {
        App(widthDp, heightDp)
    }
}