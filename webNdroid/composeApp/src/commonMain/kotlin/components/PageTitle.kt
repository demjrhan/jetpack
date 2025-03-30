package components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun PageTitle(
    isMobile: Boolean,
    padding: Dp,
    backgroundColor: Color,
    textColor: Color,
    contrastColor: Color,
    fontFamily: FontFamily,
    title: String,
    titleSize: TextUnit
) {

    BoxWithConstraints {
        TopBubbles(
            contrastColor = contrastColor,
            backgroundColor = backgroundColor,
            isMobile = isMobile
        )

        if (isMobile) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(bottomStart = 35.dp, bottomEnd = 35.dp))
                    .padding(top = padding * 4, bottom = padding, start = padding, end = padding)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .align(Alignment.Center)
                        .offset(0.dp, (-90).dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = title,
                        textAlign = TextAlign.Center,
                        color = textColor,
                        fontFamily = fontFamily,
                        fontSize = titleSize,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        } else {
            /* Currently same with mobile part, can make improvement in future */

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(bottomStart = 35.dp, bottomEnd = 35.dp))
                    .padding(top = padding * 4, bottom = padding, start = padding, end = padding)
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .align(Alignment.Center)
                        .offset(0.dp, (-110).dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = title,
                        textAlign = TextAlign.Center,
                        color = textColor,
                        fontFamily = fontFamily,
                        fontSize = titleSize,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

        }
    }
}



