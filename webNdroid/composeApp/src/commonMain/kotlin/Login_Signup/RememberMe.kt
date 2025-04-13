package Login_Signup

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import models.ResponsiveUi


@Composable
fun RememberMe(
    ui: ResponsiveUi
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .height(25.dp)
    ) {
        if (ui.isMobile) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxSize().padding(start = ui.padding),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(14.dp)
                            .clip(RoundedCornerShape(25))
                            .border(
                                width = 1.dp,
                                color = ui.checkBoxColor.copy(ui.alpha),
                                shape = RoundedCornerShape(25)
                            )
                    )
                    Spacer(Modifier.padding(start = ui.padding))
                    Text(
                        text = "Remember me",
                        fontSize = ui.fontSize,
                        color = ui.textColor,
                        modifier = Modifier.alpha(ui.alpha),
                        fontFamily = ui.fontFamily
                    )
                }
            }
        } else {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxSize().padding(start = ui.padding),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(16.dp)
                            .clip(RoundedCornerShape(25))
                            .border(
                                width = 1.dp,
                                color = ui.checkBoxColor.copy(alpha = ui.alpha),
                                shape = RoundedCornerShape(25)
                            )
                    )
                    Spacer(Modifier.padding(start = ui.padding))
                    Text(
                        text = "Remember me",
                        fontSize = ui.fontSize,
                        color = ui.textColor,
                        modifier = Modifier.alpha(ui.alpha),
                        fontFamily = ui.fontFamily
                    )
                }
            }

        }
    }
}

