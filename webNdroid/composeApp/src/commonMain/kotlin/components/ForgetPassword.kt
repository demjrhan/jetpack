package components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import models.ResponsiveUi


@Composable
fun ForgotPassword(
    ui: ResponsiveUi
) {
    /* Right side of the remember me box, that is why full size. Remember me part is 0.5f of screen. */
    BoxWithConstraints(
        modifier = Modifier
            .height(25.dp)
    ) {
        if (ui.isMobile) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = ui.padding),
                contentAlignment = Alignment.CenterEnd,

                ) {
                Text(
                    text = "Forgot Password?",
                    fontWeight = FontWeight.Bold,
                    color = ui.textColor,
                    fontSize = ui.fontSize,
                    fontFamily = ui.fontFamily
                )

            }
        } else {
            /* Currently same with mobile part, can make improvement in future */
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = ui.padding),
                contentAlignment = Alignment.CenterEnd,

                ) {
                Text(
                    text = "Forgot Password?",
                    fontWeight = FontWeight.Bold,
                    color = ui.textColor,
                    fontSize = ui.fontSize,
                    fontFamily = ui.fontFamily
                )

            }
        }
    }
}
