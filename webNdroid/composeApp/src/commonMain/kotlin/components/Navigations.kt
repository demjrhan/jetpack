package components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun NavigateToAuthScreen(
    isMobile: Boolean,
    textColor: Color,
    contrastColor: Color,
    padding: Dp,
    fontSize: TextUnit,
    fontFamily: FontFamily,
    alpha: Float,
    sentence: String,
    navigationSentence: String
) {
    BoxWithConstraints(
        modifier = Modifier
            .height(30.dp)
            .fillMaxWidth()
    ) {
        if (isMobile) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = padding),
                contentAlignment = Alignment.Center,

                ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = sentence,
                        color = textColor,
                        fontSize = fontSize,
                        fontFamily = fontFamily,
                        modifier = Modifier.alpha(alpha)
                    )
                    Spacer(Modifier.padding(horizontal = padding / 3))
                    Text(
                        text =  navigationSentence,
                        color = contrastColor,
                        fontSize = fontSize,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        } else {
            /* Currently same with mobile part, can make improvement in future */
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = padding),
                contentAlignment = Alignment.Center,

                ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = sentence,
                        color = textColor,
                        fontSize = fontSize,
                        fontFamily = fontFamily,
                        modifier = Modifier.alpha(alpha)
                    )
                    Spacer(Modifier.padding(horizontal = padding / 3))
                    Text(
                        text =  navigationSentence,
                        color = contrastColor,
                        fontSize = fontSize,
                        fontFamily = fontFamily,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }
    }
}

