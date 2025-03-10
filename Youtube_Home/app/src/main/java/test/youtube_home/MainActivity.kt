package test.youtube_home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.selection.LocalTextSelectionColors
import androidx.compose.foundation.text.selection.TextSelectionColors
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import test.youtube_home.ui.theme.Youtube_HomeTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Youtube_HomeTheme {
                var selectedItemIndex by rememberSaveable { mutableIntStateOf(0) }

                val items = listOf(
                    BottomNavigationItem(
                        title = "Home",
                        selectedIcon = Icons.Filled.Home,
                        unselectedIcon = Icons.Outlined.Home,
                        hasNews = false,
                    ),
                    BottomNavigationItem(
                        title = "Chat",
                        selectedIcon = Icons.Filled.Email,
                        unselectedIcon = Icons.Outlined.Email,
                        hasNews = false,
                        badgeCount = 45
                    ),
                    BottomNavigationItem(
                        title = "Settings",
                        selectedIcon = Icons.Filled.Settings,
                        unselectedIcon = Icons.Outlined.Settings,
                        hasNews = true,
                    ),
                )

                val videos = listOf(R.drawable.name, R.drawable.logo, R.drawable.name)
                val shorts =
                    listOf(R.drawable.name_shorts, R.drawable.logo_shorts, R.drawable.name_shorts)

                val listState = rememberLazyListState()
                var isBottomBarVisible by remember { mutableStateOf(true) }
                var previousScrollOffset by remember { mutableIntStateOf(1) }

                LaunchedEffect(listState.firstVisibleItemScrollOffset) {
                    val currentOffset = listState.firstVisibleItemScrollOffset
                    isBottomBarVisible = currentOffset < previousScrollOffset
                    previousScrollOffset = currentOffset
                }

                Youtube_HomeTheme {
                    Scaffold(
                        topBar = {
                            AnimatedVisibility(
                                visible = isBottomBarVisible,
                                enter = slideInVertically(),
                                exit = slideOutVertically()

                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(16.dp)
                                ) {
                                    CustomTextFieldRefactored(
                                        background =
                                        Color.Black, textColor = Color.White
                                    )
                                }
                            }

                        },
                        bottomBar = {
                            AnimatedVisibility(
                                visible = isBottomBarVisible,
                                enter = slideInVertically { it },
                                exit = slideOutVertically { it }
                            ) {
                                NavigationBar {
                                    items.forEachIndexed { index, item ->
                                        NavigationBarItem(
                                            selected = selectedItemIndex == index,
                                            onClick = { selectedItemIndex = index },
                                            label = { Text(text = item.title) },
                                            alwaysShowLabel = false,
                                            icon = {
                                                BadgedBox(
                                                    badge = {
                                                        if (item.badgeCount != null) {
                                                            Badge { Text(text = item.badgeCount.toString()) }
                                                        } else if (item.hasNews) {
                                                            Badge()
                                                        }
                                                    }
                                                ) {
                                                    Icon(
                                                        imageVector = if (index == selectedItemIndex) {
                                                            item.selectedIcon
                                                        } else item.unselectedIcon,
                                                        contentDescription = item.title
                                                    )
                                                }
                                            }
                                        )
                                    }
                                }
                            }
                        }
                    ) {
                        LazyColumn(
                            state = listState,
                            modifier = Modifier.fillMaxSize()
                        ) {
                            item { Videos(videos = videos, description = "empty description") }
                            item { Shorts(shorts = shorts, description = "empty description") }
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun SearchField(text: String, onValueChange: (String) -> Unit, color: Color) {
    val customTextSelectionColors = TextSelectionColors(
        handleColor = Color.Transparent,
        backgroundColor = Color.Transparent
    )

    CompositionLocalProvider(LocalTextSelectionColors provides customTextSelectionColors) {
        BasicTextField(
            value = text,
            onValueChange = onValueChange,
            textStyle = TextStyle(
                fontFamily = FontFamily.Monospace,
                color = color
            ),
            modifier = Modifier.fillMaxWidth(1f),
            cursorBrush = SolidColor(Color.Unspecified)
        )
    }


}

@Composable
fun SearchIcon(onSearch: () -> Unit, color: Color) {
    Icon(
        imageVector = Icons.Default.Search,
        contentDescription = "",
        modifier = Modifier.clickable() {
            onSearch()
        },
        tint = color
    )
}

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun DeleteIcon(visibility: Boolean, onClick: () -> Unit, color: Color) {
    AnimatedVisibility(
        visible = visibility,
        enter = fadeIn(),
        exit = fadeOut()
    ) {
        Icon(
            imageVector = Icons.Default.Clear,
            contentDescription = "",
            modifier = Modifier
                .animateEnterExit(
                    enter = slideInHorizontally(),
                    exit = slideOutVertically()
                )
                .clickable {
                    onClick()
                },
            tint = color
        )
    }
}


@Composable
fun CustomTextFieldRefactored(
    modifier: Modifier = Modifier,
    background: Color,
    textColor: Color
) {
    var text by remember { mutableStateOf("") }
    var searchText by remember { mutableStateOf("Search") }
    var isTextVisible by remember { mutableStateOf(true) }
    var searchTextAlpha by remember {
        mutableFloatStateOf(1f)
    }
    val coroutineScope = rememberCoroutineScope();
    Box(
        modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(background)
            .padding(15.dp)

    ) {
        Row(modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {

            SearchIcon(onSearch = {
                if (text.isNotEmpty()) {
                    searchTextAlpha = 0.5f
                    text = "Searched!"
                    coroutineScope.launch {
                        delay(2000)
                        searchTextAlpha = 1f
                        text = ""

                    }
                }
            }, color = textColor)

            Spacer(modifier.padding(end = 8.dp))



            Box(modifier = modifier.weight(1f)) {
                SearchField(text = text, onValueChange = { text = it }, color = textColor)
                if (text.isEmpty()) {
                    Text(
                        text = searchText,
                        color = textColor,
                        modifier = Modifier.alpha(0.5f)
                    )
                } else {
                    searchText = ""
                    modifier.alpha(searchTextAlpha)
                }
            }

            Spacer(modifier.padding(end = 8.dp))

            DeleteIcon(visibility = text.isNotEmpty(), onClick = {

                isTextVisible = false
                coroutineScope.launch {
                    delay(100)
                    text = ""
                    isTextVisible = true
                }
            }, color = textColor)
        }
    }

}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Videos(videos: List<Int>, description: String) {
    val screenHeight = LocalConfiguration.current.screenHeightDp
    val thumbnailBrush = Brush.linearGradient(
        listOf(
            Color(0xFFFADF70), // Soft Yellow
            Color(0xFFEC635E), // Coral Red
            Color(0xFF7AC07B), // Soft Green
            Color(0xFF437BDA), // Blue
            Color(0xFF000000)  // Black
        )
    )
    val screenBrush = Brush.verticalGradient(
        listOf(
            Color(0xFF000000), // Pure Black
            Color(0xFF141414), // Deep Charcoal
            Color(0xFF282828), // Dark Graphite
            Color(0xFFFFFFFF) // White
        )

    )
    Column(
        modifier = Modifier.background(screenBrush),
    ) {
        repeat(videos.size) { index ->
            if (index < videos.size) {
                Box(
                    modifier = Modifier
                        .height((screenHeight * 0.3).dp)
                        .padding(16.dp)
                        .clip(RoundedCornerShape(16.dp))
                ) {
                    HorizontalPager(
                        state = rememberPagerState(initialPage = 0, pageCount = { videos.size }),
                        pageSpacing = 16.dp,
                    ) {
                        Card(
                            colors = CardDefaults.cardColors(Color.White)
                        ) {

                            Image(
                                modifier = Modifier
                                    .background(
                                        thumbnailBrush, RoundedCornerShape(1.dp)
                                    )
                                    .weight(0.7f)
                                    .fillMaxSize()
                                    .padding(12.dp)
                                    .clip(
                                        RoundedCornerShape(
                                            topStart = 15.dp,
                                            topEnd = 15.dp,
                                            bottomStart = 8.dp,
                                            bottomEnd = 8.dp
                                        )
                                    ),
                                contentScale = ContentScale.Crop,
                                painter = painterResource(videos[index]),
                                contentDescription = description
                            )
                            Box(modifier = Modifier.weight(0.3f)) {
                                Column(modifier = Modifier.fillMaxSize(), Arrangement.Center) {
                                    Text(
                                        text = "Title",
                                        modifier = Modifier.padding(start = 16.dp),
                                        fontWeight = FontWeight.SemiBold,
                                        fontFamily = FontFamily.Monospace,
                                        fontSize = 18.sp
                                    )
                                    Text(
                                        text = "Channel Name",
                                        modifier = Modifier.padding(start = 16.dp),
                                        fontWeight = FontWeight.Normal,
                                        fontFamily = FontFamily.Monospace,
                                        fontSize = 13.sp
                                    )
                                }
                            }

                        }
                    }
                }
            }
        }


    }

}

data class BottomNavigationItem(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val hasNews: Boolean,
    val badgeCount: Int? = null
)


@Composable
fun Shorts(shorts: List<Int>, description: String) {
    val screenWidth = LocalConfiguration.current.screenWidthDp.dp
    val screenHeight = LocalConfiguration.current.screenHeightDp
    val itemWidth = screenWidth / 3
    val thumbnailBrush = Brush.linearGradient(
        listOf(
            Color(0xFFFADF70), // Soft Yellow
            Color(0xFFEC635E), // Coral Red
            Color(0xFF7AC07B), // Soft Green
            Color(0xFF437BDA), // Blue
            Color(0xFF000000)  // Black
        )
    )
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height((screenHeight * 0.3).dp)
            .padding(16.dp)
    ) {

        LazyRow(
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {

            items(shorts.size) { index ->
                Card(

                    modifier = Modifier
                        .width(itemWidth)
                        .fillMaxHeight()
                        .padding(8.dp)
                        .clip(RoundedCornerShape(6.dp))
                ) {

                    Box(modifier = Modifier.fillMaxSize()) {

                        Image(
                            modifier = Modifier
                                .background(
                                    thumbnailBrush, RoundedCornerShape(2.dp)
                                )
                                .fillMaxSize()
                                .padding(4.dp)
                                .clip(
                                    RoundedCornerShape(
                                        12.dp
                                    )
                                ),
                            contentScale = ContentScale.Crop,
                            painter = painterResource(shorts[index]),
                            contentDescription = description
                        )

                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .fillMaxHeight(0.25f)
                                .align(Alignment.BottomCenter)
                                .padding(4.dp)
                                .background(Color.Transparent)
                        ) {
                            Text(
                                text = "Short description for testing alignment.",
                                maxLines = 2,
                                lineHeight = 12.sp,
                                fontSize = 10.sp,
                                modifier = Modifier
                                    .align(Alignment.BottomStart)
                                    .padding(start = 5.dp, end = 4.dp, bottom = 4.dp),
                                style = TextStyle(
                                    shadow = Shadow(
                                        Color.White,
                                        offset = Offset(1f, 1f)
                                    )
                                ),
                                fontWeight = FontWeight.Light,
                                fontFamily = FontFamily.Monospace,
                            )
                        }
                    }


                }
            }


        }

    }

}



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true)
@Composable
fun Preview() {

}


