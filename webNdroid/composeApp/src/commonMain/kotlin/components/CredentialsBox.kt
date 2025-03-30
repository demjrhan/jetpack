package components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp


@Composable
fun CredentialsBox(
    isMobile: Boolean,
    fontSize: TextUnit,
    padding: Dp,
    textColor: Color,
    contrastColor: Color,
    alpha: Float,
    fontFamily: FontFamily,
    iconSize: Dp,
    firstBoxTitle: String,
    firstBoxHolderValue: String,
    secondBoxTitle: String,
    secondBoxHolderValue: String,
    buttonText: String,
    navigationSentence: String,
    navigationHighlightSentence: String,
    isSignUp: Boolean,
    isLogin: Boolean,
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
                        isMobile,
                        title = firstBoxTitle,
                        holderValue = firstBoxHolderValue,
                        fontSize = fontSize,
                        color = textColor,
                        padding = padding,
                        onValueChange = { email = it },
                        icon = null,
                        alpha = alpha,
                        fontFamily = fontFamily,
                        iconSize = iconSize

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
                        isMobile,
                        title = secondBoxTitle,
                        holderValue = secondBoxHolderValue,
                        fontSize = fontSize,
                        color = textColor,
                        padding = padding,
                        onValueChange = { email = it },
                        icon = Icons.Default.Refresh,
                        alpha = alpha,
                        fontFamily = fontFamily,
                        iconSize = iconSize

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
                        if (isLogin) {
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

                    }
                    /* Spacer to have some gap between components. */
                    Spacer(Modifier.padding(bottom = padding * 3))

                    /* Big button for access login,signup etc. */
                    GenericBigButton(
                        text = buttonText,
                        contrastColor = contrastColor,
                        fontSize = fontSize,
                        fontFamily = fontFamily,
                        isMobile = isMobile
                    )

                    /* Spacer to have some gap between components. */
                    Spacer(Modifier.padding(bottom = padding))

                    /* Small text under the button navigating to Sign up if user is not registered. */
                    NavigateToAuthScreen(
                        isMobile = isMobile,
                        textColor = textColor,
                        contrastColor = contrastColor,
                        padding = padding,
                        fontSize = fontSize,
                        fontFamily = fontFamily,
                        alpha = alpha,
                        sentence = navigationSentence,
                        navigationSentence = navigationHighlightSentence

                    )

                }

            }
        } else {
            Box(
                modifier = Modifier.fillMaxWidth().fillMaxHeight(0.95f).clip(
                    RoundedCornerShape(15)
                ).background(Color.Black)
                    .padding(
                        top = padding * 2,
                        bottom = padding,
                        start = padding,
                        end = padding
                    )
            ) {
                /* Column to make multiple filling areas inside of the box. */
                Column(modifier = Modifier.fillMaxSize()) {
                    CredentialArea(
                        isMobile,
                        title = firstBoxTitle,
                        holderValue = firstBoxHolderValue,
                        fontSize = fontSize,
                        color = textColor,
                        padding = padding,
                        onValueChange = { email = it },
                        icon = null,
                        alpha = alpha,
                        fontFamily = fontFamily,
                        iconSize = iconSize

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
                        isMobile,
                        title = secondBoxTitle,
                        holderValue = secondBoxHolderValue,
                        fontSize = fontSize,
                        color = textColor,
                        padding = padding,
                        onValueChange = { email = it },
                        icon = Icons.Default.Refresh,
                        alpha = alpha,
                        fontFamily = fontFamily,
                        iconSize = iconSize

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
                        if (isLogin) {
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
                    }
                    /* Spacer to have some gap between components. */
                    Spacer(Modifier.padding(padding * 2))

                    /* Big button for access login,signup etc. */
                    GenericBigButton(
                        text = "Login",
                        contrastColor = contrastColor,
                        fontSize = fontSize,
                        fontFamily = fontFamily,
                        isMobile = isMobile
                    )

                    /* Spacer to have some gap between components. */
                    Spacer(Modifier.padding(bottom = padding))

                    /* Small text under the button navigating to Sign up if user is not registered. */
                    NavigateToAuthScreen(
                        isMobile = isMobile,
                        textColor = textColor,
                        contrastColor = contrastColor,
                        padding = padding,
                        fontSize = fontSize,
                        fontFamily = fontFamily,
                        alpha = alpha,
                        sentence = "Don't have an account?",
                        navigationSentence = "Sign up!"

                    )

                }

            }
        }

    }


}
