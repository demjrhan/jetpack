package components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import models.ResponsiveUi

@Composable
fun ContentBox(ui: ResponsiveUi, height: Dp){

    BoxWithConstraints {
        if(ui.isMobile){
            Box(modifier = Modifier.fillMaxWidth().height(height).padding(ui.padding).background(
                Color(0xFF1A1A1A)).border(width = 5.dp, color = Color(0xF333333))){

            }
        }
        else {

        }
    }
}