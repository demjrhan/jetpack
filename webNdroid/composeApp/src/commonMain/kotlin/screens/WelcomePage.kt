package screens

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.BottomBar
import components.NavigationBar
import components.ToggleButton
import components.TopBar

@Composable
fun page(screenWidth: Dp, screenHeight: Dp) {

    var showNavBar by remember { mutableStateOf(false) }
    val isMobile = screenWidth < 600.dp
    val navBarWidth = if (isMobile) 250.dp else 400.dp
    val fontSize = if(isMobile) 16.sp else 24.sp
    val animatedOffset by animateDpAsState(
        targetValue = if (showNavBar) 0.dp else -navBarWidth,
        label = "SidebarSlide"
    )

    val titles = listOf("Messages", "Notifications")

    MaterialTheme {
        Scaffold(
            topBar = { TopBar(title = "LAW", fontSize = fontSize) },
            bottomBar = { BottomBar(title = "All rights are reserved.",fontSize = fontSize) }
        ) { innerPadding ->
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)

            ) {
                if (showNavBar) {
                    Box(
                        modifier = Modifier
                            .fillMaxHeight()
                            .offset(x = animatedOffset)
                    ) {

                        NavigationBar(
                            fontSize = fontSize,
                            navBarWidth = navBarWidth,
                            showNavBar = showNavBar,
                            onClick = { showNavBar = !showNavBar }
                        )
                    }
                } else {

                    Box(
                        modifier = Modifier
                            .fillMaxHeight(),
                        contentAlignment = Alignment.Center
                    ) {
                        ToggleButton(showNavBar, onClick = { showNavBar = !showNavBar })
                    }
                }

                MiddleBox(
                    modifier = Modifier.fillMaxSize(),
                    screenWidth = screenWidth,
                    isVisible = !showNavBar,
                    titles = titles,
                    fontSize = fontSize

                )
            }

        }
    }
}


@Composable
fun MiddleBox(modifier: Modifier, screenWidth: Dp, isVisible : Boolean, titles: List<String>, fontSize : TextUnit) {
    var boxCount = when {
        screenWidth < 600.dp -> 2
        screenWidth < 1000.dp -> 3
        else -> 4
    }
    val boxSize = when {
        screenWidth < 600.dp -> 300.dp
        screenWidth < 1000.dp -> 450.dp
        else -> 550.dp
    }
    if (boxCount > titles.size) boxCount = titles.size
    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val isMobile = screenWidth < 600.dp
        val customModifier = Modifier.width(boxSize).height(boxSize)
        if (isMobile) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                if(!isVisible){
                    repeat(boxCount) { index ->
                        SampleBox(customModifier.blur(5.dp), title = titles[index], fontSize = fontSize)
                    }
                } else {
                    repeat(boxCount) { index ->
                        SampleBox(customModifier , title = titles[index], fontSize = fontSize)
                    }
                }

            }
        } else {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                if(!isVisible){
                    repeat(boxCount) { index ->
                        SampleBox(customModifier.blur(5.dp), title = titles[index], fontSize = fontSize)
                    }
                } else {
                    repeat(boxCount) { index ->
                        SampleBox(customModifier , title = titles[index], fontSize = fontSize)
                    }
                }
            }

        }
    }
}

@Composable
fun SampleBox(modifier: Modifier, title : String, fontSize: TextUnit) {

    Box(
        modifier = modifier.padding(16.dp)
    ) {
        Scaffold(
            topBar = { TopBar(title, fontSize) }
        ) { paddingValues ->
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.inverseOnSurface)
                    .padding(paddingValues),
                contentAlignment = Alignment.Center
            ) {

            }
        }

    }

}


