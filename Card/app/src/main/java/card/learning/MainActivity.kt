package card.learning

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import card.learning.ui.theme.CardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CardTheme {

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    CardTheme {
        var list = listOf(
            R.drawable.feel_like_yourself, R.drawable.logo, R.drawable.feel_like_yourself
        )
        ImageCard(list = list, description = "empty description")
    }
}

@Composable
fun ImageCard(list: List<Int>, description: String) {

    val brush = Brush.linearGradient(
        listOf(
            Color(0xFFFADF70), // Soft Yellow
            Color(0xFFEC635E), // Coral Red
            Color(0xFF7AC07B), // Soft Green
            Color(0xFF437BDA), // Blue
            Color(0xFF000000)  // Black
        )
    )

    Column(modifier = Modifier.fillMaxSize()) {
        repeat(3) { index ->
            if (index < list.size) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(1f)
                        .padding(16.dp)
                ) {
                    Card(
                        colors = CardDefaults.cardColors(Color.White),
                        elevation = CardDefaults.cardElevation(8.dp)
                    ) {

                        Image(
                            modifier = Modifier
                                .background(brush, RoundedCornerShape(1.dp))
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

