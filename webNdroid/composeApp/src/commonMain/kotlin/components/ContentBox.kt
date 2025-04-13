package components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import models.ResponsiveUi



@Composable
fun ContentBoxWeb(
    ui: ResponsiveUi,
    title: String,
    isMain: Boolean,
    onToggleLeftTop: (() -> Unit)? = null,
    onToggleRightTop: (() -> Unit)? = null,
    onToggleLeftBottom: (() -> Unit)? = null,
    onToggleRightBottom: (() -> Unit)? = null,
    leftTopVisible: MutableState<Boolean>? = null,
    rightTopVisible: MutableState<Boolean>? = null,
    leftBottomVisible: MutableState<Boolean>? = null,
    rightBottomVisible: MutableState<Boolean>? = null
) {


    Column(
        modifier = Modifier
            .padding(bottom = ui.padding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.align(Alignment.Start).padding(start = ui.padding * 2)) {
            Text(
                text = title,
                fontSize = ui.boxTitleSize,
                fontFamily = ui.fontFamily,
                fontStyle = FontStyle.Italic,
                color = ui.textColor
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(ui.roundedCorner))
                .border(
                    width = 6.dp,
                    color = ui.backgroundColor.copy(alpha = ui.alpha),
                    shape = RoundedCornerShape(ui.roundedCorner)
                )
                .background(Color(0xFF1A1A1A))
                .padding(ui.padding),
        ) {


            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {


                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {

                }
            }
            if (isMain) {
                onToggleLeftTop?.let {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopStart)
                            .size(ui.iconSize*2)
                            .clip(CircleShape)
                            .background(ui.backgroundColor)
                            .clickable(onClick = it),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            imageVector = if (leftTopVisible?.value == true) Icons.Default.Close else Icons.Default.Add,
                            contentDescription = "Toggle Left-Top",
                            tint = ui.checkBoxColor
                        )
                    }
                }
                onToggleRightTop?.let {
                    Box(
                        modifier = Modifier
                            .align(Alignment.TopEnd)
                            .size(ui.iconSize*2)
                            .clip(CircleShape)
                            .background(ui.backgroundColor)
                            .clickable(onClick = it),
                        contentAlignment = Alignment.Center
                    )  {
                        Icon(
                            imageVector = if (rightTopVisible?.value == true) Icons.Default.Close else Icons.Default.Add,
                            contentDescription = "Toggle Right-Top",
                            tint = ui.checkBoxColor
                        )
                    }
                }
                onToggleLeftBottom?.let {
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomStart)
                            .size(ui.iconSize*2)
                            .clip(CircleShape)
                            .background(ui.backgroundColor)
                            .clickable(onClick = it),
                        contentAlignment = Alignment.Center
                    )  {
                        Icon(
                            imageVector = if (leftBottomVisible?.value == true) Icons.Default.Close else Icons.Default.Add,
                            contentDescription = "Toggle Left-Bottom",
                            tint = ui.checkBoxColor
                        )
                    }
                }
                onToggleRightBottom?.let {
                    Box(
                        modifier = Modifier
                            .align(Alignment.BottomEnd)
                            .size(ui.iconSize*2)
                            .clip(CircleShape)
                            .background(ui.backgroundColor)
                            .clickable(onClick = it),
                        contentAlignment = Alignment.Center
                    )  {
                        Icon(
                            imageVector = if (rightBottomVisible?.value == true) Icons.Default.Close else Icons.Default.Add,
                            contentDescription = "Toggle Right-Bottom",
                            tint = ui.checkBoxColor
                        )
                    }
                }
            }

        }
    }


}

