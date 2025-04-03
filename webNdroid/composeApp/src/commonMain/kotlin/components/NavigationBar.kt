package components


import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.DrawerState
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import models.ResponsiveUi

@Composable
fun MobileSideBar(ui: ResponsiveUi) {
    ModalDrawerSheet {
        /* Content of the navigation bar, there will be buttons for navigation. */
        Text("LAW", fontSize = ui.titleSize, fontFamily = ui.fontFamily, modifier = Modifier.padding(ui.padding).align(Alignment.CenterHorizontally))
        Text("Home", fontSize = ui.fontSize, fontFamily = ui.fontFamily, modifier = Modifier.padding(ui.padding))
        Text("Settings", fontSize = ui.fontSize, fontFamily = ui.fontFamily, modifier = Modifier.padding(ui.padding))
    }
}


@Composable
fun WebSidebar(ui: ResponsiveUi) {
    ModalDrawerSheet {
        /* Content of the navigation bar, there will be buttons for navigation. */
        Text("LAW", fontSize = ui.titleSize, fontFamily = ui.fontFamily, modifier = Modifier.padding(ui.padding))
        Text("Home", fontSize = ui.fontSize, fontFamily = ui.fontFamily, modifier = Modifier.padding(ui.padding))
        Text("Settings", fontSize = ui.fontSize, fontFamily = ui.fontFamily, modifier = Modifier.padding(ui.padding))
    }
}
