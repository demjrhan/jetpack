package screens

import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.runtime.Composable
import models.createResponsiveUi

@Composable
fun Home() {
    BoxWithConstraints() {
        val screenWidth = maxWidth
        val screenHeight = maxHeight
        val ui = createResponsiveUi(screenWidth, screenHeight)
        if (ui.isMobile) {
        } else {

        }
    }
}