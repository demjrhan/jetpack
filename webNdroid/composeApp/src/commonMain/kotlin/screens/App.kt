package screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

// ./gradlew wasmJsBrowserRun --continuous
@Preview
@Composable
fun App(screenWidth: Dp = 800.dp, screenHeight: Dp = 600.dp) {
   page(screenWidth = screenWidth, screenHeight = screenHeight)
}



