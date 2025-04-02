package models

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
    val fontFamily: FontFamily,
    val footerColor: Color,
    val headerColor: Color,
    val navigationBarWidth: Dp
)


fun createResponsiveUi(screenWidth: Dp, screenHeight: Dp): ResponsiveUi {
    val isMobile = screenWidth < 800.dp
    val navigationBarWidth = when {
        screenWidth < 800.dp -> 0.dp
        screenWidth < 1200.dp -> 180.dp
        else -> 240.dp
    }
    return ResponsiveUi(
        screenHeight = screenHeight,
        screenWidth = screenWidth,
        isMobile = isMobile,
        fontSize = if (isMobile) 14.sp else 18.sp,
        padding = if (isMobile) 12.dp else 14.dp,
        iconSize = if (isMobile) 14.dp else 18.dp,
        titleSize = if (isMobile) 70.sp else 90.sp,
        textColor = Color.White,
        backgroundColor = Color.Black,
        contrastColor = Color(0xFFF87E2B),
        alpha = 0.5f,
        fontFamily = FontFamily.SansSerif,
        footerColor = Color.White,
        headerColor = Color.White,
        navigationBarWidth = navigationBarWidth
    )
}