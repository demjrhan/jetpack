package components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.ui.tooling.preview.Preview

/* Small box sized differently depending on the platform  containing Title and TextField for value entering. */
@Preview
@Composable
fun CredentialArea(
    screenWidth: Dp,
    screenHeight: Dp,
    isMobile: Boolean,
    title: String,
    iconSize: Dp,
    holderValue: String,
    fontSize: TextUnit,
    color: Color,
    padding: Dp,
    onValueChange: (String) -> Unit,
    icon: ImageVector?,
    alpha: Float,
    fontFamily: FontFamily
) {


    var text by remember {
        mutableStateOf("null")
    }

    BoxWithConstraints {
        if (isMobile) {
            Box(modifier = Modifier.fillMaxWidth().height(65.dp)) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = fontSize,
                        fontFamily = fontFamily,
                        color = color,
                        modifier = Modifier.padding(
                            top = padding,
                            start = padding,
                        )
                    )
                    /* Usage of row: To be able to add icon in the end of the TextField */
                    Row(
                        modifier = Modifier.fillMaxSize().padding(horizontal = padding),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        /* Box sized 0.9f of possible area for entering value.*/
                        Box(modifier = Modifier.weight(1f)) {
                            BasicTextField(
                                textStyle = TextStyle(
                                    color = color,
                                    fontFamily = FontFamily.SansSerif,
                                    fontSize = fontSize
                                ),
                                modifier = Modifier.alpha(alpha),
                                value = holderValue, onValueChange = { text = it },
                                cursorBrush = SolidColor(Color.Unspecified),
                            )
                        }
                        /* Icon box, icon is centered to the middle. Reason of maxSize is top box is already filling 0.9f size of area.*/
                        Box(
                            modifier = Modifier
                                .size(iconSize),
                            contentAlignment = Alignment.Center
                        ) {
                            if (icon != null) {
                                Icon(
                                    imageVector = icon,
                                    contentDescription = icon.name,
                                    tint = color,
                                    modifier = Modifier.size(iconSize)
                                )
                            }
                        }


                    }

                }
            }
        } else {
            Box(modifier = Modifier.fillMaxWidth().height(85.dp)) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = fontSize,
                        fontFamily = fontFamily,
                        color = color,
                        modifier = Modifier.padding(
                            top = padding,
                            start = padding,
                        )
                    )
                    /* Usage of row: To be able to add icon in the end of the TextField */
                    Row(
                        modifier = Modifier.fillMaxSize().padding(horizontal = padding),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        /* Box sized 0.9f of possible area for entering value.*/
                        Box(modifier = Modifier.weight(1f)) {
                            BasicTextField(
                                textStyle = TextStyle(
                                    color = color,
                                    fontFamily = FontFamily.SansSerif,
                                    fontSize = fontSize
                                ),
                                modifier = Modifier.alpha(alpha),
                                value = holderValue, onValueChange = { text = it },
                                cursorBrush = SolidColor(Color.Unspecified),
                            )
                        }
                        /* Icon box, icon is centered to the middle. Reason of maxSize is top box is already filling 0.9f size of area.*/
                        Box(
                            modifier = Modifier
                                .size(iconSize),
                            contentAlignment = Alignment.Center
                        ) {
                            if (icon != null) {
                                Icon(
                                    imageVector = icon,
                                    contentDescription = icon.name,
                                    tint = color,
                                    modifier = Modifier.size(iconSize)
                                )
                            }
                        }


                    }

                }
            }
        }
    }
}

