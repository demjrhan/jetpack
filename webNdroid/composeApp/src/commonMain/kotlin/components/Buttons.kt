package components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import models.ResponsiveUi


@Composable
fun ToggleButton(showNavBar: Boolean, onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxHeight()) {
        Box(
            modifier = Modifier.align(Alignment.CenterEnd).height(45.dp).width(36.dp)
                .clip(RoundedCornerShape(topEnd = 50.dp, bottomEnd = 50.dp))
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Icon(
                imageVector = Icons.Default.Done,
                contentDescription = if (showNavBar) "Close" else "Open",
                modifier = Modifier.size(30.dp).align(Alignment.Center)
                    .clickable(onClick = onClick),
                tint = Color.White
            )
        }
    }

}

@Composable
fun GenericBigButton(
    ui:ResponsiveUi,
    text: String,
) {
    BoxWithConstraints {
        if (ui.isMobile) {
            Box(
                modifier = Modifier.fillMaxWidth().height(42.dp),
                contentAlignment = Alignment.Center
            ) {

                Button(
                    onClick = { /* TODO */ },
                    shape = RoundedCornerShape(25.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ui.contrastColor
                    ),
                    modifier = Modifier.fillMaxWidth(0.87f).fillMaxHeight(0.9f)
                ) {
                    Text(
                        text = text, fontSize = ui.fontSize, fontFamily = ui.fontFamily
                    )
                }
            }
        } else {
            Box(
                modifier = Modifier.fillMaxWidth().height(52.dp),
                contentAlignment = Alignment.Center
            ) {

                Button(
                    onClick = { /* TODO */ },
                    shape = RoundedCornerShape(25.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = ui.contrastColor
                    ),
                    modifier = Modifier.fillMaxWidth(0.87f).fillMaxHeight(0.9f)
                ) {
                    Text(
                        text = text, fontSize = ui.fontSize, fontFamily = ui.fontFamily
                    )
                }
            }
        }
    }

}