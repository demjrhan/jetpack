package models

import androidx.compose.foundation.background
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import components.MobileSideBar
import components.WebSidebar
import kotlinx.coroutines.CoroutineScope

@Composable
fun WebScaffold(
    ui: ResponsiveUi,
    drawerState: DrawerState,
    scope: CoroutineScope,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            WebSidebar(ui = ui)
        },
        content = content,
    )
}
@Composable
fun MobileScaffold(
    ui: ResponsiveUi,
    drawerState: DrawerState,
    scope: CoroutineScope,
    content: @Composable () -> Unit
) {
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            MobileSideBar(ui = ui)
        },
        content = content
    )
}
