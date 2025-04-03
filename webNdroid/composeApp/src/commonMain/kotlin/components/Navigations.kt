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
import models.ResponsiveUi

@Composable
fun NavigateToAuthScreen(
    ui: ResponsiveUi,
    sentence: String,
    navigationSentence: String
) {
    BoxWithConstraints(
        modifier = Modifier
            .height(30.dp)
            .fillMaxWidth()
    ) {
        if (ui.isMobile) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = ui.padding),
                contentAlignment = Alignment.Center,

                ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = sentence,
                        color = ui.textColor,
                        fontSize = ui.fontSize,
                        fontFamily = ui.fontFamily,
                        modifier = Modifier.alpha(ui.alpha)
                    )
                    Spacer(Modifier.padding(horizontal = ui.padding / 3))
                    Text(
                        text =  navigationSentence,
                        color = ui.contrastColor,
                        fontSize = ui.fontSize,
                        fontFamily = ui.fontFamily,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        } else {
            /* Currently same with mobile part, can make improvement in future */
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = ui.padding),
                contentAlignment = Alignment.Center,

                ) {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = sentence,
                        color = ui.textColor,
                        fontSize = ui.fontSize,
                        fontFamily = ui.fontFamily,
                        modifier = Modifier.alpha(ui.alpha)
                    )
                    Spacer(Modifier.padding(horizontal = ui.padding / 3))
                    Text(
                        text =  navigationSentence,
                        color = ui.contrastColor,
                        fontSize = ui.fontSize,
                        fontFamily = ui.fontFamily,
                        fontWeight = FontWeight.Bold
                    )
                }

            }
        }
    }
}

