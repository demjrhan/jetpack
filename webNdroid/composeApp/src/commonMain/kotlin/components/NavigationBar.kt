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
import models.FooterNavigationItem
import models.ResponsiveUi

@Composable
fun FooterMobile() {
    val items = listOf(
        FooterNavigationItem(
            title = "Home",
            selectedIcon = Icons.Filled.Home,
            unselectedIcon = Icons.Outlined.Home,
            hasNews = false,
        ),
        FooterNavigationItem(
            title = "Chat",
            selectedIcon = Icons.Filled.Email,
            unselectedIcon = Icons.Outlined.Email,
            hasNews = false,
            badgeCount = 45
        ),
        FooterNavigationItem(
            title = "Settings",
            selectedIcon = Icons.Filled.Settings,
            unselectedIcon = Icons.Outlined.Settings,
            hasNews = false,
        ),
        FooterNavigationItem(
            title = "Settings",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
            hasNews = false,
        ),
    )
    var selectedItemIndex by rememberSaveable {
        mutableStateOf(0)
    }

    NavigationBar {

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedItemIndex == index,
                onClick = { selectedItemIndex = index },
                label = { Text(item.title) },
                alwaysShowLabel = false,
                icon = {
                    BadgedBox(
                        badge = {
                            if (item.badgeCount != null) {
                                Badge {
                                    Text(text = item.badgeCount.toString())
                                }
                            } else if (item.hasNews) {
                                Badge()
                            }
                        }
                    ) {
                        Icon(
                            imageVector = if (index == selectedItemIndex) {
                                item.selectedIcon
                            } else item.unselectedIcon,
                            contentDescription = item.title
                        )
                    }
                }

            )
        }
    }

}
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
