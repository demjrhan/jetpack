package components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp

@Composable
fun TopBar(title: String, fontSize: TextUnit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = title,
            maxLines = 1,
            fontSize = fontSize,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun BottomBar(title: String, fontSize: TextUnit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.CenterEnd,
    ) {
        Text(
            text = title,
            fontSize = fontSize,
            maxLines = 1,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(end = 16.dp),

            )
    }
}


@Composable
fun NavigationBar(navBarWidth: Dp, showNavBar: Boolean, onClick: () -> Unit, fontSize: TextUnit) {
    Box(
        modifier = Modifier
            .width(navBarWidth)
            .fillMaxHeight()
            .background(Color.Black)
    ) {

        Text(
            "Nav",
            fontSize = fontSize,
            color = Color.White,
            modifier = Modifier.align(Alignment.Center)
        )

        Box(
            modifier = Modifier.align(Alignment.CenterEnd)
                .height(45.dp)
                .width(36.dp)
                .clip(RoundedCornerShape(topStart = 50.dp, bottomStart = 50.dp))
                .background(MaterialTheme.colorScheme.primary)
        ) {
            Icon(
                imageVector = Icons.Default.Close,
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
