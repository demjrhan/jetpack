import androidx.compose.material.icons.Icons
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview
import screens.LoginPage

// ./gradlew wasmJsBrowserRun --continuous
@Preview
@Composable
fun App(screenWidth: Dp = 800.dp, screenHeight: Dp = 600.dp) {

   LoginPage(screenWidth = screenWidth, screenHeight = screenHeight)
}



