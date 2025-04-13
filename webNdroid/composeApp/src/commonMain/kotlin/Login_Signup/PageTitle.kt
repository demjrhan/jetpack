package Login_Signup

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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import models.ResponsiveUi


@Composable
fun PageTitle(
    ui: ResponsiveUi,
    title: String,
) {

    BoxWithConstraints {
        TopBubbles(
            ui = ui
        )

        if (ui.isMobile) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(bottomStart = 35.dp, bottomEnd = 35.dp))
                    .padding(top = ui.padding * 4, bottom = ui.padding, start = ui.padding, end = ui.padding)
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
                        color = ui.textColor,
                        fontFamily = ui.fontFamily,
                        fontSize = ui.titleSize,
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
                    .padding(top = ui.padding * 4, bottom = ui.padding, start = ui.padding, end = ui.padding)
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
                        color = ui.textColor,
                        fontFamily = ui.fontFamily,
                        fontSize = ui.titleSize,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

        }
    }
}



