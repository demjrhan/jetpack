package components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import models.ResponsiveUi
import org.jetbrains.compose.resources.painterResource
import webndroid.composeapp.generated.resources.Res
import webndroid.composeapp.generated.resources.android_background
import webndroid.composeapp.generated.resources.web_background

@Composable
fun MobileHomeContent(ui: ResponsiveUi, innerPadding: PaddingValues) {

    val listState = rememberLazyListState()
    Box(
        modifier = Modifier.fillMaxSize().paint(
            painter = painterResource(Res.drawable.android_background),
            contentScale = ContentScale.Crop
        )
            .padding(ui.padding)
    ) {
        LazyColumn(
            state = listState,
            modifier = Modifier.fillMaxSize(),
            contentPadding = innerPadding,
            verticalArrangement = Arrangement.spacedBy(ui.padding)
        ) {
            item { ContentBoxMobile(ui, title = "Active Cases") }
        }

    }
}

@Composable
fun WebHomeContent(ui: ResponsiveUi, innerPadding: PaddingValues) {
    val items1 = remember { List(10) { "Box 1 - Item ${it + 1}" } }
    val items2 = remember { List(7) { "Box 2 - Item ${it + 1}" } }
    val items3 = remember { List(6) { "Box 3 - Item ${it + 1}" } }
    val items4 = remember { List(12) { "Box 4 - Item ${it + 1}" } }
    val items5 = remember { List(4) { "Box 5 - Item ${it + 1}" } }

    var page1 by remember { mutableStateOf(0) }
    var page2 by remember { mutableStateOf(0) }
    var page3 by remember { mutableStateOf(0) }
    var page4 by remember { mutableStateOf(0) }
    var page5 by remember { mutableStateOf(0) }

    Box(
        modifier = Modifier.fillMaxSize().paint(
            painter = painterResource(Res.drawable.web_background),
            contentScale = ContentScale.Crop
        ).padding(innerPadding)
    ) {
        Row(
            modifier = Modifier.fillMaxSize().padding(ui.padding),
            horizontalArrangement = Arrangement.spacedBy(ui.padding)
        ) {
            Column(
                modifier = Modifier.weight(1f).fillMaxHeight()
            ) {
                ContentBoxWeb(
                    ui = ui, title = "Active Cases 1",
                    items = items1,
                    currentPage = page1,
                    onPrevious = { if (page1 > 0) page1-- },
                    onNext = {
                        val max = (items1.size + 2) / 3 - 1
                        if (page1 < max) page1++
                    }
                )
            }

            Column(
                modifier = Modifier.weight(1f).fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(ui.padding)
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    ContentBoxWeb(
                        ui = ui, title = "Active Cases 2",
                        items = items2,
                        currentPage = page2,
                        onPrevious = { if (page2 > 0) page2-- },
                        onNext = {
                            val max = (items2.size + 2) / 3 - 1
                            if (page2 < max) page2++
                        }
                    )
                }
                Box(modifier = Modifier.weight(1f)) {
                    ContentBoxWeb(
                        ui = ui, title = "Active Cases 3",
                        items = items3,
                        currentPage = page3,
                        onPrevious = { if (page3 > 0) page3-- },
                        onNext = {
                            val max = (items3.size + 2) / 3 - 1
                            if (page3 < max) page3++
                        }
                    )
                }
            }

            Column(
                modifier = Modifier.weight(1f).fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(ui.padding)
            ) {
                Box(modifier = Modifier.weight(2f)) {
                    ContentBoxWeb(
                        ui = ui, title = "Active Cases 4",
                        items = items4,
                        currentPage = page4,
                        onPrevious = { if (page4 > 0) page4-- },
                        onNext = {
                            val max = (items4.size + 2) / 3 - 1
                            if (page4 < max) page4++
                        }
                    )
                }
                Box(modifier = Modifier.weight(1f)) {
                    ContentBoxWeb(
                        ui = ui, title = "Active Cases 5",
                        items = items5,
                        currentPage = page5,
                        onPrevious = { if (page5 > 0) page5-- },
                        onNext = {
                            val max = (items5.size + 2) / 3 - 1
                            if (page5 < max) page5++
                        }
                    )
                }
            }
        }
    }
}

