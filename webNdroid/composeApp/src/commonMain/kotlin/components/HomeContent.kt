package components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.layout.ContentScale
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


    val leftTopVisible = remember { mutableStateOf(false) }
    val leftBottomVisible = remember { mutableStateOf(false) }
    val rightTopVisible = remember { mutableStateOf(false) }
    val rightBottomVisible = remember { mutableStateOf(false) }

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
                modifier = Modifier.weight(1f).fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(ui.padding)
            ) {
                AnimatedVisibility(
                    /* initialOffsetX & targetOffsetX makes us to play with where sliding animation start|end */
                    enter = slideInHorizontally(initialOffsetX = { +it }) + fadeIn(),
                    exit = slideOutHorizontally(targetOffsetX = { +it }) + fadeOut(),
                    visible = leftTopVisible.value,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {

                        ContentBoxWeb(
                            ui = ui,
                            title = "Messages",
                            isMain = false,
                            leftTopVisible = leftTopVisible
                        )
                    }
                }

                AnimatedVisibility(
                    /* initialOffsetX & targetOffsetX makes us to play with where sliding animation start|end */
                    enter = slideInHorizontally(initialOffsetX = { +it }) + fadeIn(),
                    exit = slideOutHorizontally(targetOffsetX = { +it }) + fadeOut(),
                    visible = leftBottomVisible.value,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        ContentBoxWeb(
                            ui = ui,
                            title = "Upcoming Meetings",
                            isMain = false,
                            leftTopVisible = leftTopVisible
                        )
                    }
                }

            }

            Column(
                modifier = Modifier.weight(1f).fillMaxHeight()
            ) {
                ContentBoxWeb(
                    ui = ui,
                    title = "Active Cases",
                    isMain = true,
                    onToggleLeftTop = { leftTopVisible.value = !leftTopVisible.value },
                    onToggleRightTop = { rightTopVisible.value = !rightTopVisible.value },
                    onToggleLeftBottom = { leftBottomVisible.value = !leftBottomVisible.value },
                    onToggleRightBottom = { rightBottomVisible.value = !rightBottomVisible.value },
                    leftTopVisible = leftTopVisible,
                    rightTopVisible = rightTopVisible,
                    leftBottomVisible = leftBottomVisible,
                    rightBottomVisible = rightBottomVisible


                )

            }

            Column(
                modifier = Modifier.weight(1f).fillMaxHeight(),
                verticalArrangement = Arrangement.spacedBy(ui.padding)
            ) {
                /* initialOffsetX & targetOffsetX makes us to play with where sliding animation start|end */
                AnimatedVisibility(
                    enter = slideInHorizontally() + fadeIn(),
                    exit = slideOutHorizontally() + fadeOut(),
                    visible = rightTopVisible.value,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        ContentBoxWeb(
                            ui = ui,
                            title = "Notifications",
                            isMain = false,
                            leftTopVisible = leftTopVisible
                        )
                    }
                }

                /* initialOffsetX & targetOffsetX makes us to play with where sliding animation start|end */
                AnimatedVisibility(
                    enter = slideInHorizontally() + fadeIn(),
                    exit = slideOutHorizontally() + fadeOut(),
                    visible = rightBottomVisible.value,
                    modifier = Modifier.weight(1f)
                ) {
                    Box(modifier = Modifier.fillMaxSize()) {
                        ContentBoxWeb(
                            ui = ui,
                            title = "Requested Documents",
                            isMain = false,
                            leftTopVisible = leftTopVisible
                        )
                    }
                }

            }


        }
    }
}

