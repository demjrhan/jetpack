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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
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
fun Videos(list: List<Int>, description: String) {
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
            Color(0xFF282828) // Dark Graphite
        )

    )
    Column(
        modifier = Modifier
            .background(screenBrush),
    ) {
        repeat(list.size - 1) { index ->
            if (index < list.size) {
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .padding(16.dp)
                        .clip(RoundedCornerShape(16.dp))
                ) {
                    HorizontalPager(
                        state = rememberPagerState(
                            initialPage = 0,
                            pageCount = { list.size }),
                        pageSpacing = 16.dp,
                    ) {
                        Card(
                            colors = CardDefaults.cardColors(Color.White)
                        ) {

                            Image(
                                modifier = Modifier
                                    .background(thumbnailBrush, RoundedCornerShape(1.dp))
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
                                painter = painterResource(list[index]),
                                contentDescription = description
                            )
                            Box(modifier = Modifier.weight(0.3f)) {
                                Column(modifier = Modifier.fillMaxSize(), Arrangement.Center) {
                                    Text(
                                        text = "Title",
                                        modifier = Modifier
                                            .padding(start = 16.dp),
                                        fontWeight = FontWeight.SemiBold,
                                        fontFamily = FontFamily.Monospace,
                                        fontSize = 18.sp
                                    )
                                    Text(
                                        text = "Channel Name",
                                        modifier = Modifier
                                            .padding(start = 16.dp),
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

@Composable
fun Shorts(list: List<Int>, description: String) {


}


@Preview(showBackground = true)
@Composable
fun Preview() {
    Youtube_HomeTheme {
        val list = listOf(
            R.drawable.feel_like_yourself, R.drawable.logo, R.drawable.feel_like_yourself
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .weight(3f)
                    .fillMaxWidth()
            ) {
                Videos(list = list, description = "empty description")
            }

            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            ) {
                Shorts(list = list, description = "empty description")
            }
        }
    }
}
