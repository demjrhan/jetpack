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
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.GenericBigButton
import org.jetbrains.compose.ui.tooling.preview.Preview

@Preview
@Composable
fun LoginPage(screenWidth: Dp, screenHeight: Dp) {
    val isMobile = screenWidth < 600.dp
    val fontSize = if (isMobile) 14.sp else 22.sp
    val padding = if (isMobile) 12.dp else 18.dp
    val textColor = Color.White;
    val backgroundColor = Color.Black;
    val contrastColor = Color(0xFFF87E2B);
    val alpha = 0.5f
    val fontFamily = FontFamily.SansSerif

    BoxWithConstraints {
        if (isMobile) {
            /* Create box size of full screen and make a half of screen sized padding to make box on bottom.*/
            Box(modifier = Modifier.fillMaxSize().background(Color(0xFFF5E1))) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Box(modifier = Modifier.weight(1f)) {
                        PageTitle(
                            screenWidth = screenWidth,
                            screenHeight = screenHeight,
                            isMobile = isMobile,
                            fontSize = fontSize,
                            padding = padding,
                            textColor = textColor,
                            backgroundColor = backgroundColor,
                            contrastColor = contrastColor,
                            alpha = alpha,
                            fontFamily = fontFamily,
                            title = "Login"
                        )
                    }
                    //Spacer(Modifier.weight(1f))

                    Box(modifier = Modifier.weight(1f)) {
                        CredentialsBox(
                            screenWidth = screenWidth,
                            screenHeight = screenHeight,
                            isMobile = isMobile,
                            fontSize = fontSize,
                            padding = padding,
                            backgroundColor = backgroundColor,
                            textColor = textColor,
                            contrastColor = contrastColor,
                            alpha = alpha,
                            fontFamily = fontFamily,
                        )
                    }

                }

            }
        }
    }
}

@Composable
fun PageTitle(
    screenWidth: Dp,
    screenHeight: Dp,
    isMobile: Boolean,
    fontSize: TextUnit,
    padding: Dp,
    backgroundColor: Color,
    textColor: Color,
    contrastColor: Color,
    alpha: Float,
    fontFamily: FontFamily,
    title: String
) {
    val titleSize = if (isMobile) 45.sp else 55.sp
    BoxWithConstraints() {

        TopBubbles(contrastColor = contrastColor, backgroundColor = backgroundColor )
        if (isMobile) {
            Box(
                modifier = Modifier.fillMaxSize().clip(
                    RoundedCornerShape(bottomStart = 35.dp, bottomEnd = 35.dp)
                )
                    .padding(top = padding * 4, bottom = padding, start = padding, end = padding)
            ) {
                Box(
                    modifier = Modifier.fillMaxWidth().height(150.dp).align(Alignment.Center)
                        .offset(
                            0.dp,
                            (-90).dp
                        ), contentAlignment = Alignment.Center
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

@Composable
fun CredentialsBox(
    screenWidth: Dp,
    screenHeight: Dp,
    isMobile: Boolean,
    fontSize: TextUnit,
    padding: Dp,
    textColor: Color,
    backgroundColor: Color,
    contrastColor: Color,
    alpha: Float,
    fontFamily: FontFamily
) {
    var email by remember {
        mutableStateOf("")
    }

    /* Create a box sized differently depending on the platform. */
    BoxWithConstraints() {
        if (isMobile) {
            Box(
                modifier = Modifier.fillMaxSize().clip(
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
                        color = textColor,
                        padding = padding,
                        onValueChange = { email = it },
                        icon = null,
                        alpha = alpha,
                        fontFamily = fontFamily

                    );
                    /* Horizontal bar to divide areas */
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = textColor,
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
                        color = textColor,
                        padding = padding,
                        onValueChange = { email = it },
                        icon = Icons.Default.Refresh,
                        alpha = alpha,
                        fontFamily = fontFamily

                    );
                    /* Horizontal bar to divide areas */
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = textColor,
                        modifier = Modifier.padding(horizontal = padding)
                    )

                    /* Spacer to have some gap between components. */
                    Spacer(Modifier.padding(bottom = padding))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        /* Remember me box */
                        RememberMe(
                            color = textColor,
                            isMobile = isMobile,
                            padding = padding,
                            alpha = alpha,
                            fontSize = fontSize,
                            fontFamily = fontFamily
                        )

                        /* Forgot password box */
                        ForgotPassword(
                            color = contrastColor,
                            isMobile = isMobile,
                            padding = padding,
                            fontSize = fontSize,
                            fontFamily = fontFamily
                        )
                    }
                    /* Spacer to have some gap between components. */
                    Spacer(Modifier.padding(bottom = padding * 3))

                    /* Big button for access login,signup etc. */
                    GenericBigButton(
                        text = "Login",
                        contrastColor = contrastColor,
                        fontSize = fontSize,
                        fontFamily = fontFamily
                    )

                    /* Spacer to have some gap between components. */
                    Spacer(Modifier.padding(bottom = padding))

                    /* Small text under the button navigating to Sign up if user is not registered. */
                    SignUpNavigation(
                        isMobile = isMobile,
                        textColor = textColor,
                        contrastColor = contrastColor,
                        padding = padding,
                        fontSize = fontSize,
                        fontFamily = fontFamily,
                        alpha = alpha

                    )

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
    alpha: Float,
    fontFamily: FontFamily
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
                        fontFamily = fontFamily,
                        color = color,
                        modifier = Modifier.padding(
                            top = padding,
                            start = padding,
                            bottom = padding
                        )
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
                                    .alpha(alpha),
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
        }
    }
}

@Composable
fun ForgotPassword(
    isMobile: Boolean,
    color: Color,
    padding: Dp,
    fontSize: TextUnit,
    fontFamily: FontFamily
) {
    BoxWithConstraints(
        modifier = Modifier
            .height(25.dp)
    ) {
        if (isMobile) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(end = padding),
                contentAlignment = Alignment.CenterEnd,

                ) {
                Text(
                    text = "Forgot Password?",
                    fontWeight = FontWeight.Bold,
                    color = color,
                    fontSize = fontSize,
                    fontFamily = fontFamily
                )

            }
        }
    }
}

@Composable
fun SignUpNavigation(
    isMobile: Boolean,
    textColor: Color,
    contrastColor: Color,
    padding: Dp,
    fontSize: TextUnit,
    fontFamily: FontFamily,
    alpha: Float
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
                        text = "Don't have on account?",
                        color = textColor,
                        fontSize = fontSize,
                        fontFamily = fontFamily,
                        modifier = Modifier.alpha(alpha)
                    )
                    Spacer(Modifier.padding(horizontal = padding / 3))
                    Text(
                        text = "Sign up",
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

@Composable
fun TopBubbles(
    backgroundColor: Color,
    contrastColor: Color,
){
    Box(
        modifier = Modifier
            .size(400.dp)
            .offset(-(120.dp),-(180.dp))
            .graphicsLayer {
                rotationY = 15f
            }
            .clip(RoundedCornerShape(88.dp))
            .background(backgroundColor)
    )
    Box(
        modifier = Modifier
            .size(400.dp)
            .offset(50.dp,-(190.dp))
            .graphicsLayer {
                rotationZ = 15f
            }
            .clip(RoundedCornerShape(88.dp))
            .background(backgroundColor)
    )
    Box(
        modifier = Modifier
            .size(400.dp)
            .offset(0.dp,-(200.dp))
            .graphicsLayer {
                rotationZ = 15f
            }
            .clip(RoundedCornerShape(88.dp))
            .background(contrastColor)
    )

}