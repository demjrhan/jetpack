package test.youtube_home

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import test.youtube_home.ui.theme.Youtube_HomeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Youtube_HomeTheme {

            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Videos(videos: List<Int>, description: String) {
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
        repeat(videos.size - 1) { index ->
            if (index < videos.size) {
                Box(
                    modifier = Modifier
                        .weight(1f)
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

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Shorts(shorts: List<Int>, description: String) {
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
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            HorizontalPager(
                state = rememberPagerState(initialPage = 0, pageCount = { shorts.size }),
            ) {
                repeat(shorts.size) { index ->
                    Card(

                        modifier = Modifier
                            .fillMaxHeight()
                            .fillMaxWidth(0.33f)
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
                                    color = Color.White,
                                    modifier = Modifier
                                        .align(Alignment.BottomStart)
                                        .padding(start = 5.dp, end = 4.dp, bottom = 4.dp),
                                    style = TextStyle(shadow = Shadow(
                                        Color.Black,
                                        offset = Offset(1f, 1f))
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

}


@Preview(showBackground = true)
@Composable
fun Preview() {
    Youtube_HomeTheme {
        val videos = listOf(
            R.drawable.name, R.drawable.logo, R.drawable.name
        )
        val shorts = listOf(
            R.drawable.name_shorts, R.drawable.logo_shorts, R.drawable.name_shorts
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxWidth()
            ) {
                Videos(videos = videos, description = "empty description")
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Shorts(shorts = shorts, description = "empty description")
            }

        }
    }
}
