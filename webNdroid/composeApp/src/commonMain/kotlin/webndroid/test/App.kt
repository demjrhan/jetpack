package webndroid.test


import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Button
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

// ./gradlew wasmJsBrowserRun --continuous
@Preview
@Composable
fun App(screenWidth: Dp = 800.dp, screenHeight: Dp = 600.dp) {
    var showNavBar by remember { mutableStateOf(false) }
    val navBarWidth = if (screenWidth < 600.dp) 150.dp else 160.dp
    val animatedOffset by animateDpAsState(
        targetValue = if (showNavBar) 0.dp else -navBarWidth,
        label = "SidebarSlide"
    )
    MaterialTheme {
        Scaffold(
            topBar = { TopBar() },
            bottomBar = { BottomBar() }
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
                    ) {
                        Box(
                            modifier = Modifier
                                .fillMaxHeight()
                                .offset(x = animatedOffset)
                        ) {
                            Row {
                                NavigationBar(
                                    navBarWidth = navBarWidth,
                                    showNavBar = showNavBar,
                                    onToggle = { showNavBar = !showNavBar }
                                )
                            }
                        }
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

                // Main content
                MiddleBox(
                    modifier = Modifier.fillMaxSize(),
                    screenWidth = screenWidth
                )
            }

        }
    }
}

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


@Composable
fun TopBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = "My App Test",
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(start = 16.dp)
        )
    }
}

@Composable
fun BottomBar() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(64.dp)
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.CenterEnd
    ) {
        Text(
            text = "My App Test",
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(end = 16.dp),

            )
    }
}

@Composable
fun MiddleBox(modifier: Modifier, screenWidth: Dp) {

    BoxWithConstraints(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        val isMobile = screenWidth < 600.dp


        if (isMobile) {
            // Vertical layout for mobile
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                SampleBox("Box 1", Modifier.fillMaxWidth().height(100.dp))
                SampleBox("Box 2", Modifier.fillMaxWidth().height(100.dp))
            }
        } else {
            // Horizontal layout for web/desktop
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
            ) {
                val boxWidth = 250.dp
                SampleBox("Box 1", Modifier.width(boxWidth).height(200.dp))
                SampleBox("Box 2", Modifier.width(boxWidth).height(200.dp))
            }
        }
    }
}

@Composable
fun SampleBox(label: String, modifier: Modifier) {
    Box(
        modifier = modifier
            .padding(8.dp)
            .background(MaterialTheme.colorScheme.primaryContainer),
        contentAlignment = Alignment.Center
    ) {
        Text(text = label, color = MaterialTheme.colorScheme.onPrimaryContainer)
    }
}


@Composable
fun NavigationBar(navBarWidth: Dp, showNavBar: Boolean, onToggle: () -> Unit) {

    Box(
        modifier = Modifier
            .width(navBarWidth)
            .fillMaxHeight()
            .background(Color.Black)
    ) {
        // Your Nav content
        Text(
            "Nav",
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
                    .clickable(onClick = onToggle),
                tint = Color.White
            )
        }

    }
}
