package components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


@Composable
fun ToggleButton(showNavBar: Boolean, onClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxHeight()){
        Box(
            modifier = Modifier.align(Alignment.CenterEnd)
                .height(45.dp)
                .width(36.dp)
                .clip(RoundedCornerShape(topEnd = 50.dp, bottomEnd = 50.dp))
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Icon(
                imageVector = Icons.Default.Done,
                contentDescription = if (showNavBar) "Close" else "Open",
                modifier = Modifier
                    .size(30.dp)
                    .align(Alignment.Center)
                    .clickable(onClick = onClick),
                tint = Color.White
            )
        }
    }

}
