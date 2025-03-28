package webndroid.test

import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.ComposeViewport
import kotlinx.browser.document
import kotlinx.browser.window
import org.w3c.dom.events.Event
import App

fun pxToDp(px: Double): Dp = (px / window.devicePixelRatio).dp

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    ComposeViewport(document.body!!) {
        /* MutableStateOf to not forget the last screen size. */
        var widthDp by remember { mutableStateOf(pxToDp(window.innerWidth.toDouble())) }
        var heightDp by remember { mutableStateOf(pxToDp(window.innerHeight.toDouble())) }

        /* To resize elements dynamically there is listener to get current size of the screen */
        LaunchedEffect(Unit) {
            val listener: (Event) -> Unit = {
                widthDp = pxToDp(window.innerWidth.toDouble())
                heightDp = pxToDp(window.innerHeight.toDouble())
            }
            window.addEventListener("resize", listener)

        }

        App(widthDp, heightDp)
    }
}
