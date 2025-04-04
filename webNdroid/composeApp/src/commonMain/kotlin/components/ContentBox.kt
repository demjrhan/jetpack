package components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import models.ResponsiveUi

@Composable
fun ContentBoxMobile(ui: ResponsiveUi, title: String) {
    Column(
        modifier = Modifier
            .padding(bottom = ui.padding)
            .fillMaxWidth()
            .height(400.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.align(Alignment.Start).padding(start = ui.padding + ui.padding)) {
            Text(
                text = title,
                fontSize = ui.boxTitleSize,
                fontFamily = ui.fontFamily,
                fontStyle = FontStyle.Italic,
                color = ui.textColor
            )
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(ui.roundedCorner))
                .border(
                    width = 6.dp,
                    color = ui.backgroundColor.copy(alpha = ui.alpha),
                    shape = RoundedCornerShape(ui.roundedCorner)
                )
                .background(Color(0xFF1A1A1A))
                .padding(ui.padding),
            contentAlignment = Alignment.Center
        ) {

        }
    }
}

@Composable
fun ContentBoxWeb(
    ui: ResponsiveUi,
    title: String,
    items: List<String>,
    currentPage: Int,
    onPrevious: () -> Unit,
    onNext: () -> Unit
) {
    val itemsPerPage = 3
    val pageCount = (items.size + itemsPerPage - 1) / itemsPerPage
    val currentItems = items.drop(currentPage * itemsPerPage).take(itemsPerPage)

    Column(
        modifier = Modifier
            .padding(bottom = ui.padding)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(modifier = Modifier.align(Alignment.Start).padding(start = ui.padding * 2)) {
            Text(
                text = title,
                fontSize = ui.boxTitleSize,
                fontFamily = ui.fontFamily,
                fontStyle = FontStyle.Italic,
                color = ui.textColor
            )
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .clip(RoundedCornerShape(ui.roundedCorner))
                .border(
                    width = 6.dp,
                    color = ui.backgroundColor.copy(alpha = ui.alpha),
                    shape = RoundedCornerShape(ui.roundedCorner)
                )
                .background(Color(0xFF1A1A1A))
                .padding(ui.padding),
            contentAlignment = Alignment.TopCenter
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                currentItems.forEach {
                    Text(it, color = Color.White)
                }
                Row(
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Button(onClick = onPrevious, enabled = currentPage > 0) {
                        Text("←")
                    }
                    Text("Page ${currentPage + 1} / $pageCount", color = Color.White)
                    Button(onClick = onNext, enabled = currentPage < pageCount - 1) {
                        Text("→")
                    }
                }
            }
        }
    }
}
