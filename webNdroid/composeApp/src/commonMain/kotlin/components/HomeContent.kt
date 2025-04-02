package components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import models.ResponsiveUi
import org.jetbrains.compose.resources.painterResource
import webndroid.composeapp.generated.resources.Res
import webndroid.composeapp.generated.resources.android_background
import webndroid.composeapp.generated.resources.web_background

@Composable
fun MobileHomeContent(ui: ResponsiveUi){
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(Res.drawable.android_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}
@Composable
fun WebHomeContent(ui: ResponsiveUi){
    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(Res.drawable.web_background),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
    }
}
