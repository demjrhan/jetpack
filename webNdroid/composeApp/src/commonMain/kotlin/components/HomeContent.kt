package components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
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
fun MobileHomeContent(ui: ResponsiveUi, innerPadding:PaddingValues){

    val listState = rememberLazyListState()
    Box(modifier = Modifier.fillMaxSize().paint(
        painter = painterResource(Res.drawable.android_background),
        contentScale = ContentScale.Crop
    )){
        LazyColumn(state = listState, modifier = Modifier.fillMaxSize(), contentPadding = innerPadding){
            item { ContentBox(ui, height = 300.dp) }
            item { ContentBox(ui, height = 300.dp) }
            item { ContentBox(ui, height = 300.dp) }
        }

    }
}
@Composable
fun WebHomeContent(ui: ResponsiveUi, innerPadding:PaddingValues){
    Box(modifier = Modifier.fillMaxSize().paint(
        painter = painterResource(Res.drawable.web_background),
        contentScale = ContentScale.Crop
    )){

    }
}
