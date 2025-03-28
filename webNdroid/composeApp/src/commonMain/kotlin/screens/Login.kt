package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.HorizontalDivider
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun LoginPage(screenWidth: Dp, screenHeight: Dp) {
    val isMobile = screenWidth < 600.dp
    val fontSize = if (isMobile) 14.sp else 22.sp
    val padding = if (isMobile) 12.dp else 18.dp
    val color = Color.White;
    val alpha = 0.7f
    /* Create box size of full screen and make a half of screen sized padding to make box on bottom.*/
    Box(modifier = Modifier.fillMaxSize().background(Color(0xFFF5E1))) {
        Column(modifier = Modifier.fillMaxSize()) {
            Spacer(Modifier.weight(1f))
            CredentialsBox(
                screenWidth = screenWidth,
                screenHeight = screenHeight,
                isMobile = isMobile,
                fontSize = fontSize,
                padding = padding,
                color = color,
                alpha = alpha
            )
        }

    }

}

@Composable
fun CredentialsBox(
    screenWidth: Dp,
    screenHeight: Dp,
    isMobile: Boolean,
    fontSize: TextUnit,
    padding: Dp,
    color: Color,
    alpha: Float
) {
    var email by remember {
        mutableStateOf("")
    }

    /* Create a box sized differently depending on the platform. */
    BoxWithConstraints() {
        if (isMobile) {
            Box(
                modifier = Modifier.fillMaxWidth().height(screenHeight / 2).clip(
                    RoundedCornerShape(topStart = 35.dp, topEnd = 35.dp)
                ).background(Color.Black)
                    .padding(top = padding * 4, bottom = padding, start = padding, end = padding)
            ) {
                /* Column to make multiple filling areas inside of the box. */
                Column(modifier = Modifier.fillMaxSize()) {
                    CredentialArea(
                        screenWidth,
                        screenHeight,
                        isMobile,
                        title = "Email",
                        holderValue = "Enter your email address",
                        fontSize = fontSize,
                        color = color,
                        padding = padding,
                        onValueChange = { email = it },
                        icon = null,
                        alpha = alpha

                    );
                    /* Horizontal bar to divide areas */
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = color,
                        modifier = Modifier.padding(horizontal = padding)
                    )

                    /* Spacer to have some gap between components. */
                    Spacer(Modifier.padding(bottom = padding))

                    CredentialArea(
                        screenWidth,
                        screenHeight,
                        isMobile,
                        title = "Password",
                        holderValue = "Enter password",
                        fontSize = fontSize,
                        color = color,
                        padding = padding,
                        onValueChange = { email = it },
                        icon = Icons.Default.Refresh,
                        alpha = alpha

                    );
                    /* Horizontal bar to divide areas */
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = color,
                        modifier = Modifier.padding(horizontal = padding)
                    )

                    /* Spacer to have some gap between components. */
                    Spacer(Modifier.padding(bottom = padding))

                    /* Remember me box */
                    RememberMe(color = color, isMobile = isMobile, padding = padding, alpha = alpha, fontSize = fontSize)

                }

            }
        }
    }


}


/* Small box sized differently depending on the platform  containing Title and TextField for value entering. */
@Preview
@Composable
fun CredentialArea(
    screenWidth: Dp,
    screenHeight: Dp,
    isMobile: Boolean,
    title: String,
    holderValue: String,
    fontSize: TextUnit,
    color: Color,
    padding: Dp,
    onValueChange: (String) -> Unit,
    icon: ImageVector?,
    alpha: Float
) {


    var text by remember {
        mutableStateOf("null")
    }

    BoxWithConstraints {
        if (isMobile) {
            Box(modifier = Modifier.fillMaxWidth().height(70.dp).background(Color.Black)) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Text(
                        text = title,
                        fontWeight = FontWeight.Bold,
                        fontSize = fontSize,
                        fontFamily = FontFamily.SansSerif,
                        color = color,
                        modifier = Modifier.padding(top = padding, start = padding)
                    )
                    /* Usage of row: To be able to add icon in the end of the TextField */
                    Row(modifier = Modifier.fillMaxSize()) {
                        /* Box sized 0.9f of possible area for entering value.*/
                        Box(modifier = Modifier.fillMaxWidth(0.9f)) {
                            BasicTextField(
                                textStyle = TextStyle(
                                    color = color,
                                    fontFamily = FontFamily.SansSerif
                                ),
                                modifier = Modifier.padding(top = padding / 2, start = padding)
                                    .alpha(0.7f),
                                value = holderValue, onValueChange = { text = it },
                                cursorBrush = SolidColor(Color.Unspecified),
                            )
                        }
                        /* Icon box, icon is centered to the middle. Reason of maxSize is top box is already filling 0.9f size of area.*/
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            if (icon != null) {
                                Icon(
                                    imageVector = icon,
                                    contentDescription = "",
                                    tint = color,
                                    modifier = Modifier.size(16.dp)
                                )
                            }
                        }


                    }

                }
            }
        }
    }
}


@Composable
fun RememberMe(
    isMobile: Boolean,
    color: Color,
    padding: Dp,
    fontSize: TextUnit,
    alpha: Float
) {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxWidth(0.5f)
            .height(25.dp)
    ) {
        if (isMobile) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.Black),
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
                    Text (
                        text = "Remember me",
                        fontSize = fontSize,
                        color = color,
                        modifier = Modifier.alpha(alpha)
                    )
                }
            }
        }
    }
}