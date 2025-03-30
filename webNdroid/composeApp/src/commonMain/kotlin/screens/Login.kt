package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.CredentialsBox
import components.PageTitle
import org.jetbrains.compose.ui.tooling.preview.Preview

data class ResponsiveUi(
    val screenHeight: Dp,
    val screenWidth: Dp,
    val isMobile: Boolean,
    val fontSize: TextUnit,
    val iconSize: Dp,
    val padding: Dp,
    val textColor: Color,
    val titleSize: TextUnit,
    val backgroundColor: Color,
    val contrastColor: Color,
    val alpha: Float,
    val fontFamily: FontFamily
)

fun createResponsiveUi(screenWidth: Dp, screenHeight: Dp): ResponsiveUi {
    val isMobile = screenWidth < 800.dp
    return ResponsiveUi(
        screenHeight = screenHeight,
        screenWidth = screenWidth,
        isMobile = isMobile,
        fontSize = if (isMobile) 14.sp else 18.sp,
        padding = if (isMobile) 12.dp else 14.dp,
        iconSize = if (isMobile) 14.dp else 18.dp,
        titleSize = if (isMobile) 45.sp else 90.sp,
        textColor = Color.White,
        backgroundColor = Color.Black,
        contrastColor = Color(0xFFF87E2B),
        alpha = 0.5f,
        fontFamily = FontFamily.SansSerif
    )
}

@Preview
@Composable
fun Login() {
    BoxWithConstraints() {
        val screenWidth = maxWidth
        val screenHeight = maxHeight
        val ui = createResponsiveUi(screenWidth, screenHeight)
        if (ui.isMobile) {
            /* Create box size of full screen and make a half of screen sized padding to make box on bottom.*/
            Box(modifier = Modifier.fillMaxSize().background(Color(0xFFF5E1))) {
                Column(modifier = Modifier.fillMaxSize()) {
                    Box(modifier = Modifier.weight(1f)) {
                        PageTitle(
                            isMobile = ui.isMobile,
                            padding = ui.padding,
                            textColor = ui.textColor,
                            backgroundColor = ui.backgroundColor,
                            contrastColor = ui.contrastColor,
                            fontFamily = ui.fontFamily,
                            title = "Login",
                            titleSize = ui.titleSize
                        )
                    }
                    //Spacer(Modifier.weight(1f))

                    Box(modifier = Modifier.weight(1f)) {
                        CredentialsBox(
                            isMobile = ui.isMobile,
                            fontSize = ui.fontSize,
                            padding = ui.padding,
                            textColor = ui.textColor,
                            contrastColor = ui.contrastColor,
                            alpha = ui.alpha,
                            fontFamily = ui.fontFamily,
                            iconSize = ui.iconSize,
                            firstBoxTitle = "Email",
                            firstBoxHolderValue = "Enter y our email address",
                            secondBoxTitle = "Password",
                            secondBoxHolderValue = "Enter password",
                            buttonText = "Login",
                            navigationSentence = "Don't have account?",
                            navigationHighlightSentence = "Sign up!",
                            isLogin = true,
                            isSignUp = false
                        )
                    }

                }

            }
        } else {
            Box(modifier = Modifier.fillMaxSize()) {
                /* Create box size of full screen and make a half of screen sized padding to make box on bottom.*/
                Box(
                    modifier = Modifier.fillMaxWidth(0.4f).fillMaxHeight()
                        .background(Color(0xFFF5E1)).align(Alignment.Center),
                ) {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        Box(modifier = Modifier.weight(1f)) {
                            PageTitle(
                                isMobile = ui.isMobile,
                                padding = ui.padding,
                                textColor = ui.textColor,
                                backgroundColor = ui.backgroundColor,
                                contrastColor = ui.contrastColor,
                                fontFamily = ui.fontFamily,
                                title = "Login",
                                titleSize = ui.titleSize
                            )
                        }
                        //Spacer(Modifier.weight(1f))

                        Box(modifier = Modifier.weight(1f)) {
                            CredentialsBox(
                                isMobile = ui.isMobile,
                                fontSize = ui.fontSize,
                                padding = ui.padding,
                                textColor = ui.textColor,
                                contrastColor = ui.contrastColor,
                                alpha = ui.alpha,
                                fontFamily = ui.fontFamily,
                                iconSize = ui.iconSize,
                                firstBoxTitle = "Email",
                                firstBoxHolderValue = "Enter your email address",
                                secondBoxTitle = "Password",
                                secondBoxHolderValue = "Enter password",
                                buttonText = "Login",
                                navigationSentence = "Don't have account?",
                                navigationHighlightSentence = "Sign up!",
                                isLogin = true,
                                isSignUp = false
                            )
                        }

                    }

                }
            }
        }

    }
}
