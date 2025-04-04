package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import models.ResponsiveUi

@Composable
fun CasesBox(ui: ResponsiveUi) {
    BoxWithConstraints {
        if (ui.isMobile) {
            Box(
                modifier = Modifier.fillMaxWidth().height(ui.boxHeight)
                    .clip(RoundedCornerShape(ui.roundedCorner - 15.dp))
                    .background(
                        ui.backgroundColor.copy(alpha = ui.alpha)
                    )
            ) {

            }
        } else {
            Box(
                modifier = Modifier.fillMaxWidth().height(ui.boxHeight)
                    .clip(RoundedCornerShape(ui.roundedCorner - 15.dp))
                    .background(
                        ui.backgroundColor.copy(alpha = ui.alpha)
                    )
            ) {

            }
        }
    }
}