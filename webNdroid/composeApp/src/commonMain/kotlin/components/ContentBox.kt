package components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import models.ResponsiveUi

@Composable
fun ContentBox(ui: ResponsiveUi) {

    BoxWithConstraints {
        if (ui.isMobile) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .border(width = 6.dp, color = ui.backgroundColor, shape = RoundedCornerShape(ui.roundedCorner))
                    .clip(RoundedCornerShape(ui.roundedCorner))
                    .background(Color(0xFF1A1A1A).copy(alpha = ui.alpha))
                    .padding(ui.padding)
            )
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .border(width = 6.dp, color = ui.backgroundColor, shape = RoundedCornerShape(ui.roundedCorner))
                    .clip(RoundedCornerShape(ui.roundedCorner))
                    .background(Color(0xFF1A1A1A).copy(alpha = ui.alpha))
                    .padding(ui.padding)

            )
        }
    }
}