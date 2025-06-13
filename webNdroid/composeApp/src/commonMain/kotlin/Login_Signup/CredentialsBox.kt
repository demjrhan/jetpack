import Login_Signup.CredentialArea
import Login_Signup.ForgotPassword
import Login_Signup.RememberMe
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
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
import androidx.compose.ui.unit.dp
import components.GenericBigButton
import components.NavigateToAuthScreen
import models.ResponsiveUi

@Composable
fun CredentialsBox(
    // Updated parameter names for better readability
    firstNameTitle: String = "First Name",
    firstNamePlaceholder: String = "Enter your first name",
    lastNameTitle: String = "Last Name",
    lastNamePlaceholder: String = "Enter your last name",
    emailTitle: String, // Kept as is, assuming it's distinct
    emailPlaceholder: String,
    passwordTitle: String,
    passwordPlaceholder: String,
    birthdayTitle: String = "Birthday",
    birthdayPlaceholder: String = "Enter your birthday (e.g., MM/DD/YYYY)",
    buttonText: String,
    navigationSentence: String,
    navigationHighlightSentence: String,
    isSignUp: Boolean, // Consider if this is still needed with more specific fields
    isLogin: Boolean,
    ui: ResponsiveUi
) {
    // State for email, you'll need similar states for other input fields
    var emailValue by remember { mutableStateOf("") }
    var firstNameValue by remember { mutableStateOf("") }
    var lastNameValue by remember { mutableStateOf("") }
    var passwordValue by remember { mutableStateOf("") }
    var birthdayValue by remember { mutableStateOf("") }

    BoxWithConstraints {
        val scrollState = rememberScrollState() // Common scroll state for both mobile and desktop

        if (ui.isMobile) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(
                        RoundedCornerShape(topStart = ui.roundedCorner, topEnd = ui.roundedCorner)
                    )
                    .background(Color.Black)
                    .padding(
                        top = ui.padding * 4,
                        bottom = ui.padding,
                        start = ui.padding,
                        end = ui.padding
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState)
                ) {
                    CredentialArea(
                        ui = ui,
                        title = firstNameTitle,
                        holderValue = firstNamePlaceholder,
                        onValueChange = { firstNameValue = it },
                        icon = null
                    )
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = ui.textColor,
                        modifier = Modifier.padding(horizontal = ui.padding)
                    )
                    Spacer(Modifier.padding(bottom = ui.padding))

                    CredentialArea(
                        ui = ui,
                        title = lastNameTitle,
                        holderValue = lastNamePlaceholder,
                        onValueChange = { lastNameValue = it },
                        icon = null
                    )
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = ui.textColor,
                        modifier = Modifier.padding(horizontal = ui.padding)
                    )
                    Spacer(Modifier.padding(bottom = ui.padding))

                    CredentialArea(
                        ui = ui,
                        title = emailTitle,
                        holderValue = emailPlaceholder,
                        onValueChange = { emailValue = it },
                        icon = null
                    )
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = ui.textColor,
                        modifier = Modifier.padding(horizontal = ui.padding)
                    )
                    Spacer(Modifier.padding(bottom = ui.padding))

                    CredentialArea(
                        ui = ui,
                        title = passwordTitle,
                        holderValue = passwordPlaceholder,
                        onValueChange = { passwordValue = it },
                        icon = Icons.Default.Refresh
                    )
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = ui.textColor,
                        modifier = Modifier.padding(horizontal = ui.padding)
                    )
                    Spacer(Modifier.padding(bottom = ui.padding))

                    CredentialArea(
                        ui = ui,
                        title = birthdayTitle,
                        holderValue = birthdayPlaceholder,
                        onValueChange = { birthdayValue = it },
                        icon = Icons.Default.DateRange
                    )
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = ui.textColor,
                        modifier = Modifier.padding(horizontal = ui.padding)
                    )
                    Spacer(Modifier.padding(bottom = ui.padding))

                    Row(modifier = Modifier.fillMaxWidth()) {
                        if (isLogin) {
                            RememberMe(ui = ui)
                            ForgotPassword(ui = ui)
                        }
                    }
                    Spacer(Modifier.padding(bottom = ui.padding * 3))

                    GenericBigButton(
                        text = buttonText,
                        ui = ui
                        // Add onClick lambda here to handle form submission
                    )
                    Spacer(Modifier.padding(bottom = ui.padding))

                    NavigateToAuthScreen(
                        ui = ui,
                        sentence = navigationSentence,
                        navigationSentence = navigationHighlightSentence
                        // Add onClick lambda for navigation
                    )
                }
            }
        } else { // Desktop version
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.95f) // Keeps some padding from the top/bottom of the screen
                    .clip(RoundedCornerShape(15.dp)) // Consistent dp usage
                    .background(Color.Black)
                    .padding(
                        top = ui.padding * 2,
                        bottom = ui.padding,
                        start = ui.padding,
                        end = ui.padding
                    )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState) // Apply scrolling to desktop as well
                ) {
                    // --- Fields for Desktop ---
                    // You can arrange them differently if needed, e.g., in two columns
                    // For simplicity, using the same single column layout as mobile here.

                    CredentialArea(
                        ui = ui,
                        title = firstNameTitle,
                        holderValue = firstNamePlaceholder,
                        onValueChange = { firstNameValue = it },
                        icon = null
                    )
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = ui.textColor,
                        modifier = Modifier.padding(horizontal = ui.padding)
                    )
                    Spacer(Modifier.padding(bottom = ui.padding))

                    CredentialArea(
                        ui = ui,
                        title = lastNameTitle,
                        holderValue = lastNamePlaceholder,
                        onValueChange = { lastNameValue = it },
                        icon = null
                    )
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = ui.textColor,
                        modifier = Modifier.padding(horizontal = ui.padding)
                    )
                    Spacer(Modifier.padding(bottom = ui.padding))

                    CredentialArea(
                        ui = ui,
                        title = emailTitle,
                        holderValue = emailPlaceholder,
                        onValueChange = { emailValue = it },
                        icon = null
                    )
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = ui.textColor,
                        modifier = Modifier.padding(horizontal = ui.padding)
                    )
                    Spacer(Modifier.padding(bottom = ui.padding))

                    CredentialArea(
                        ui = ui,
                        title = passwordTitle,
                        holderValue = passwordPlaceholder,
                        onValueChange = { passwordValue = it },
                        icon = Icons.Default.Refresh
                    )
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = ui.textColor,
                        modifier = Modifier.padding(horizontal = ui.padding)
                    )
                    Spacer(Modifier.padding(bottom = ui.padding))

                    CredentialArea(
                        ui = ui,
                        title = birthdayTitle,
                        holderValue = birthdayPlaceholder,
                        onValueChange = { birthdayValue = it },
                        icon = Icons.Default.DateRange
                    )
                    HorizontalDivider(
                        thickness = 1.dp,
                        color = ui.textColor,
                        modifier = Modifier.padding(horizontal = ui.padding)
                    )
                    Spacer(Modifier.padding(bottom = ui.padding))


                    Row(modifier = Modifier.fillMaxWidth()) {
                        if (isLogin) {
                            RememberMe(ui = ui)
                            ForgotPassword(ui = ui)
                        }
                    }
                    Spacer(Modifier.padding(ui.padding * 2)) // Slightly different spacing for desktop

                    GenericBigButton(
                        text = buttonText,
                        ui = ui
                        // Add onClick lambda here
                    )
                    Spacer(Modifier.padding(bottom = ui.padding))

                    NavigateToAuthScreen(
                        ui = ui,
                        sentence = navigationSentence,
                        navigationSentence = navigationHighlightSentence // Corrected this, was navigationSentence twice
                        // Add onClick lambda for navigation
                    )
                }
            }
        }
    }
}