package models

import androidx.compose.ui.graphics.vector.ImageVector

data class FooterNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)


fun createFooterNavigationItem(
    title: String,
    selectedIcon: ImageVector,
    unselectedIcon: ImageVector,
    hasNews: Boolean,
    badgeCount: Int?
): FooterNavigationItem {
    return FooterNavigationItem(
        title = title,
        selectedIcon = selectedIcon,
        unselectedIcon = unselectedIcon,
        hasNews = hasNews,
        badgeCount = badgeCount
    )
}