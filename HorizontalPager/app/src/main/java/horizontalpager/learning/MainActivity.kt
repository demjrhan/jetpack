package horizontalpager.learning


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import horizontalpager.learning.ui.theme.HorizontalPagerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HorizontalPagerTheme() {
               /* TODO */
            }
        }
    }
}


@Composable
@Preview
fun Preview() {
    val list = listOf(
        R.drawable.frog, R.drawable.wolf
    )
    Cards(list, "empty description")
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Cards(
    list: List<Int>, description: String
) {
    val pagerCount = 3

    Column(modifier = Modifier.fillMaxSize()) {
        repeat(pagerCount) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                HorizontalPager(
                    state = rememberPagerState(
                        initialPage = 0,
                        pageCount = { list.size })
                ) { page ->
                    Box(
                        modifier = Modifier
                            .fillMaxSize()

                    ) {
                        Image(
                            painter = painterResource(id = list[page]),
                            contentDescription = description,
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .align(alignment = Alignment.Center)
                                .padding(25.dp)
                                .fillMaxSize()
                        )
                        Text(
                            text = "$page",
                            modifier = Modifier
                                .padding(35.dp)
                                .background(
                                    Color.Black,
                                    shape = RoundedCornerShape(5.dp)
                                )
                                .padding(8.dp)
                                .align(Alignment.BottomEnd),
                            color = Color.White
                        )

                    }
                }


            }

        }


    }
}
