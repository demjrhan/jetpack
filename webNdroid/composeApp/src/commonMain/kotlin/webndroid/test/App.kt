import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App(
    screenWidth: Dp,
    screenHeight: Dp
) {
    MaterialTheme {
        Scaffold(
            topBar = {
                // Using size() explicitly sets both width and height.
                Box(
                    modifier = Modifier
                        .size(width = screenWidth, height = screenHeight/12) // Typical top bar height.
                        .background(Color.Black)
                )
            }
        ) {
            // Your scaffold content goes here.
        }
    }
}
