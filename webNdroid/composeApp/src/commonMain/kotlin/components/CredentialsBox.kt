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
import models.ResponsiveUi


@Composable
fun CredentialsBox(
    firstBoxTitle: String,
    firstBoxHolderValue: String,
    secondBoxTitle: String,
    secondBoxHolderValue: String,
    buttonText: String,
    navigationSentence: String,
    navigationHighlightSentence: String,
    isSignUp: Boolean,
    isLogin: Boolean,
    ui: ResponsiveUi
) {
    var email by remember {
        mutableStateOf("")
    }

    /* Create a box sized differently depending on the platform. */
    BoxWithConstraints() {
        if (ui.isMobile) {
            Box(
                modifier = Modifier.fillMaxSize().clip(
                    RoundedCornerShape(topStart = ui.roundedCorner, topEnd = ui.roundedCorner)
                ).background(Color.Black)
                    .padding(
                        top = ui.padding * 4,
                        bottom = ui.padding,
                        start = ui.padding,
                        end = ui.padding
                    )
            ) {
                /* Column to make multiple filling areas inside of the box. */
                Column(modifier = Modifier.fillMaxSize()) {
                    CredentialArea(
                        ui = ui,
                        title = firstBoxTitle,
                        holderValue = firstBoxHolderValue,
                        onValueChange = { email = it },
                        icon = null
                    );
                    /* Horizontal bar to divide areas */
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = ui.textColor,
                        modifier = Modifier.padding(horizontal = ui.padding)
                    )

                    /* Spacer to have some gap between components. */
                    Spacer(Modifier.padding(bottom = ui.padding))

                    CredentialArea(
                        ui = ui,
                        title = secondBoxTitle,
                        holderValue = secondBoxHolderValue,
                        onValueChange = { email = it },
                        icon = Icons.Default.Refresh

                    );
                    /* Horizontal bar to divide areas */
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = ui.textColor,
                        modifier = Modifier.padding(horizontal = ui.padding)
                    )

                    /* Spacer to have some gap between components. */
                    Spacer(Modifier.padding(bottom = ui.padding))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        if (isLogin) {
                            /* Remember me box */
                            RememberMe(
                                ui = ui
                            )
                            /* Forgot password box */
                            ForgotPassword(
                                ui = ui
                            )
                        }

                    }
                    /* Spacer to have some gap between components. */
                    Spacer(Modifier.padding(bottom = ui.padding * 3))

                    /* Big button for access login,signup etc. */
                    GenericBigButton(
                        text = buttonText,
                        ui = ui
                    )

                    /* Spacer to have some gap between components. */
                    Spacer(Modifier.padding(bottom = ui.padding))

                    /* Small text under the button navigating to Sign up if user is not registered. */
                    NavigateToAuthScreen(
                        ui = ui,
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
                        top = ui.padding * 2,
                        bottom = ui.padding,
                        start = ui.padding,
                        end = ui.padding
                    )
            ) {
                /* Column to make multiple filling areas inside of the box. */
                Column(modifier = Modifier.fillMaxSize()) {
                    CredentialArea(
                        ui = ui,
                        title = firstBoxTitle,
                        holderValue = firstBoxHolderValue,
                        onValueChange = { email = it },
                        icon = null,

                        );
                    /* Horizontal bar to divide areas */
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = ui.textColor,
                        modifier = Modifier.padding(horizontal = ui.padding)
                    )

                    /* Spacer to have some gap between components. */
                    Spacer(Modifier.padding(bottom = ui.padding))

                    CredentialArea(
                        ui = ui,
                        title = secondBoxTitle,
                        holderValue = secondBoxHolderValue,
                        onValueChange = { email = it },
                        icon = Icons.Default.Refresh

                    );
                    /* Horizontal bar to divide areas */
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = ui.textColor,
                        modifier = Modifier.padding(horizontal = ui.padding)
                    )

                    /* Spacer to have some gap between components. */
                    Spacer(Modifier.padding(bottom = ui.padding))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        if (isLogin) {
                            /* Remember me box */
                            RememberMe(
                                ui = ui
                            )
                            /* Forgot password box */
                            ForgotPassword(
                                ui = ui
                            )
                        }
                    }
                    /* Spacer to have some gap between components. */
                    Spacer(Modifier.padding(ui.padding * 2))

                    /* Big button for access login,signup etc. */
                    GenericBigButton(
                        text = "Login",
                        ui = ui
                    )

                    /* Spacer to have some gap between components. */
                    Spacer(Modifier.padding(bottom = ui.padding))

                    /* Small text under the button navigating to Sign up if user is not registered. */
                    NavigateToAuthScreen(
                        ui = ui,
                        sentence = "Don't have an account?",
                        navigationSentence = "Sign up!"

                    )

                }

            }
        }

    }


}
