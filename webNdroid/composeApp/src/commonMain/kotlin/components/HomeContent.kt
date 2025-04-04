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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
            item { ContentBoxMobile(ui, title = "Active Cases", type = "cases") }
        }

    }
}

@Composable
fun WebHomeContent(ui: ResponsiveUi, innerPadding: PaddingValues) {
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
                ContentBoxWeb(ui = ui, type = "cases", title = "Active Cases")

            }

            Column(
                modifier = Modifier.weight(1f).fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(ui.padding)

            ) {
                Box(modifier = Modifier.weight(1f)) {
                    ContentBoxWeb(ui = ui, type = "cases", title = "Active Cases")

                }
                Box(modifier = Modifier.weight(1f)) {
                    ContentBoxWeb(ui = ui, type = "cases", title = "Active Cases")

                }

            }

            Column(
                modifier = Modifier.weight(1f).fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(ui.padding)

            ) {

                Box(modifier = Modifier.weight(2f)) {
                    ContentBoxWeb(ui = ui, type = "cases", title = "Active Cases")

                }
                Box(modifier = Modifier.weight(1f)) {
                    ContentBoxWeb(ui = ui, type = "cases", title = "Active Cases")

                }

            }


        }
    }
}
