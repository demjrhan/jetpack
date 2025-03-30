package webndroid.test

import App
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    val screenWidth: Dp = window.innerWidth.dp
    val screenHeight: Dp = window.innerHeight.dp

    ComposeViewport(document.body!!) {
        App(screenWidth, screenHeight)
    }
}
