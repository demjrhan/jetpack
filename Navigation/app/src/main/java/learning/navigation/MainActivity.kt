package learning.navigation

import android.graphics.Paint.Align
import android.os.Bundle
import android.provider.MediaStore.Video
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.hoverable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsHoveredAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VideoScreen()
        }
    }
}

/*@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController, startDestination = "screenA") {
        composable("screenA") { ScreenA { navController.navigate("screenB") } }
        composable("screenB") { ScreenB { navController.navigate("screenA") } }
    }
}

@Composable
fun ScreenA(onNavigate: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Green),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = onNavigate) {
            Text("Go to Screen B")
        }
    }
}

@Composable
fun ScreenB(onNavigate: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Blue),
        contentAlignment = Alignment.Center
    ) {
        Button(onClick = onNavigate) {
            Text("Go to Screen A")
        }
    }
}

//@Preview(showBackground = true)
@Composable
fun PreviewScreenA() {
    ScreenA {}
}

//@Preview(showBackground = true)
@Composable
fun PreviewScreenB() {
    ScreenB {}
}*/

@Preview(showBackground = true)
@Composable
fun VideoScreen(
    padding: Dp = 15.dp
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF131414))
            .padding(start = 16.dp, end = 16.dp, top = 16.dp)
    ) {
        Column() {
            Box(
                modifier = Modifier
                    .fillMaxHeight(0.3f)
                    .fillMaxWidth()
                    .background(Color.DarkGray)

            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(padding),
                    contentScale = ContentScale.Crop
                )
            }
            VideoDescription()
            Spacer(Modifier.padding(8.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .alpha(0.9f)
                    .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                    .background(Color.Black)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(10) {
                    Comment()
                }
            }
        }
    }
}

@Preview(showBackground = true, backgroundColor = 0x00000000)
@Composable
fun Comment(text: String = "default text", padding: Dp = 16.dp, color: Color = Color.White) {
    var likeState by remember {
        mutableStateOf(false)
    }
    val icon = if (!likeState) Icons.Default.FavoriteBorder else Icons.Default.Favorite

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .padding(5.dp)
                    .width(50.dp)
                    .height(50.dp)
                    .fillMaxHeight()
                    .clip(RoundedCornerShape(55.dp))
                    .background(Color.DarkGray)

            ) {
                Image(
                    painter = painterResource(R.drawable.ic_launcher_foreground),
                    contentDescription = null,
                    modifier = Modifier.align(Alignment.Center)
                )

            }
            Spacer(modifier = Modifier.width(4.dp))

            Box(
                modifier = Modifier
                    .weight(0.8f)
                    .fillMaxHeight()
            ) {
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.spacedBy(2.dp)

                ) {
                    Text(
                        text = "@ChannelName",
                        Modifier.padding(start = 10.dp, top = 4.dp),
                        fontWeight = FontWeight.Bold,
                        color = color
                    )
                    Text(
                        text = "Very beautiful video!", Modifier.padding(start = 10.dp),
                        color = color
                    )
                    Box(
                        modifier = Modifier
                            .padding(start = 10.dp, top = 4.dp)
                            .fillMaxWidth()
                            .fillMaxHeight()
                    ) {
                        Row {
                            Icon(
                                icon,
                                tint = color,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(15.dp)
                                    .clickable(onClick = {
                                        likeState = !likeState
                                    })

                            )
                            Spacer(Modifier.padding(horizontal = 4.dp))
                            Icon(
                                Icons.Default.Info,
                                tint = color,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(15.dp)
                                    .clickable(onClick = {
                                        /* TODO */
                                    })

                            )
                        }


                    }

                }

            }
        }
    }

}

@Preview
@Composable
fun VideoDescription(color: Color = Color.White) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(180.dp)
    ) {
        Column() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(70.dp)
                    .background(Color(0xFF030303))
            ) {

                Box(
                    modifier = Modifier
                        .weight(0.7f)
                        .fillMaxHeight()

                ) {
                    Row(modifier = Modifier.fillMaxSize()) {
                        Image(
                            painter = painterResource(R.drawable.ic_launcher_foreground),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(10.dp)
                                .clip(RoundedCornerShape(28.dp))
                                .size(50.dp)
                                .background(Color.DarkGray)
                        )
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.spacedBy(2.dp)

                        ) {
                            Text(
                                text = "@ChannelName",
                                Modifier.padding(top = 10.dp),
                                fontWeight = FontWeight.Bold,
                                color = color
                            )
                            Text(
                                text = "Welcome to my video",
                                color = color
                            )
                        }
                    }

                }

                Spacer(Modifier.width(10.dp))

                Box(
                    modifier = Modifier
                        .weight(0.3f)
                        .fillMaxHeight()
                        .padding(end = 10.dp),
                    contentAlignment = Alignment.CenterEnd
                ) {

                    Row() {
                        Icon(
                            Icons.Default.ThumbUp,
                            contentDescription = null,
                            tint = color,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(Modifier.width(5.dp))
                        Icon(
                            Icons.Default.ThumbUp,
                            contentDescription = null,
                            tint = color,
                            modifier = Modifier.size(16.dp)
                        )
                        Spacer(Modifier.width(5.dp))
                        Icon(
                            Icons.Default.ThumbUp,
                            contentDescription = null,
                            tint = color,
                            modifier = Modifier.size(16.dp)
                        )
                    }

                }

            }

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clip(
                        RoundedCornerShape(bottomStart = 25.dp, bottomEnd = 25.dp)
                    )
                    .background(Color.Black)
                    .alpha(0.8f)
                    .padding(start = 12.dp, top = 12.dp, end = 12.dp, bottom = 12.dp)
            ) {
                Text(
                    text = stringResource(R.string.video_description),

                    color = color,

                    )

            }
        }
    }
}