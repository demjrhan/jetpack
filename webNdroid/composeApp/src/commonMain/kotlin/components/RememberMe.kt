package components

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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp


@Composable
fun RememberMe(
    isMobile: Boolean,
    color: Color,
    padding: Dp,
    fontSize: TextUnit,
    alpha: Float,
    fontFamily: FontFamily
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .height(25.dp)
    ) {
        if (isMobile) {
            Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    modifier = Modifier.fillMaxSize().padding(start = padding),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(14.dp)
                            .clip(RoundedCornerShape(25))
                            .border(
                                width = 1.dp,
                                color = color.copy(alpha),
                                shape = RoundedCornerShape(25)
                            )
                    )
                    Spacer(Modifier.padding(start = padding))
                    Text(
                        text = "Remember me",
                        fontSize = fontSize,
                        color = color,
                        modifier = Modifier.alpha(alpha),
                        fontFamily = fontFamily
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
                    modifier = Modifier.fillMaxSize().padding(start = padding),
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(16.dp)
                            .clip(RoundedCornerShape(25))
                            .border(
                                width = 1.dp,
                                color = color.copy(alpha),
                                shape = RoundedCornerShape(25)
                            )
                    )
                    Spacer(Modifier.padding(start = padding))
                    Text(
                        text = "Remember me",
                        fontSize = fontSize,
                        color = color,
                        modifier = Modifier.alpha(alpha),
                        fontFamily = fontFamily
                    )
                }
            }

        }
    }
}

