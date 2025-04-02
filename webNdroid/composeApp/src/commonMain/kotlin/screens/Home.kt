package screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import components.FooterMobile
import components.MobileHomeContent
import components.WebSidebar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import models.MobileScaffold
import models.ResponsiveUi
import models.WebScaffold
import models.createResponsiveUi
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.painterResource


/*
In Android, the common Top Bar and Bottom Bar size is 56.dp.
In Web, the common Top Bar size is 60.dp.
In Web, the common Bottom Bar size is 60.dp or 64.dp.
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    BoxWithConstraints() {
        val screenWidth = maxWidth
        val screenHeight = maxHeight
        val drawerState = rememberDrawerState(DrawerValue.Closed)
        val scope = rememberCoroutineScope()

        val ui = createResponsiveUi(screenWidth, screenHeight)

        if (ui.isMobile) {
            MobileScaffold(ui = ui, drawerState = drawerState, scope = scope){
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { },
                            navigationIcon = {
                                IconButton(onClick = {
                                    scope.launch { drawerState.open() }
                                }) {
                                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                                }
                            },
                        )
                    },
                    content = {
                    }
                )
            }

        } else {
            WebScaffold(ui = ui, drawerState = drawerState, scope = scope) {
                Scaffold(
                    topBar = {
                        TopAppBar(
                            title = { },
                            navigationIcon = {
                                IconButton(onClick = {
                                    scope.launch { drawerState.open() }
                                }) {
                                    Icon(Icons.Default.Menu, contentDescription = "Menu")
                                }
                            },
                        )
                    },
                    content = {


                    }
                )
            }
        }
    }
}
