package textfield.learning

import android.annotation.SuppressLint
import android.graphics.Paint.Align
import android.opengl.Visibility
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.MutableTransitionState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text2.BasicTextField2
import androidx.compose.foundation.text2.input.rememberTextFieldState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Delay
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import textfield.learning.ui.theme.TextFieldLearningTheme
import java.util.Timer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TextFieldLearningTheme {

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun Preview() {
    TextFieldLearningTheme {
        Column(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(MaterialTheme.colorScheme.primary),
                contentAlignment = Alignment.Center
            ) {
                CustomTextField()
            }
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                CustomTextField2()
            }
        }


    }
}

@Composable
fun SearchField(text: String, onValueChange: (String) -> Unit) {
    BasicTextField(
        value = text,
        onValueChange = onValueChange,
        textStyle = TextStyle(
            fontFamily = FontFamily.Monospace
        ),
        modifier = Modifier.fillMaxWidth(1f)
    )
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
fun DeleteIcon(visibility: Boolean, onClick: () -> Unit) {
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
                    enter = slideInVertically(),
                    exit = slideOutVertically()
                )
                .clickable {
                    onClick()
                }
        )
    }
}


@Composable
fun CustomTextField2(
    modifier: Modifier = Modifier
) {
    var text by remember { mutableStateOf("") }
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
            .background(MaterialTheme.colorScheme.primary)
            .padding(15.dp)

    ) {
        Row() {

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
            }, color = Color.White)

            Spacer(modifier.padding(end = 8.dp))

            SearchField(text = text, onValueChange =
            { text = it })
        }
    }

}


@Composable
fun CustomTextField(
    modifier: Modifier = Modifier
) {

    var text by remember { mutableStateOf("") }
    var isTextVisible by remember { mutableStateOf(true) }
    var searchTextAlpha by remember {
        mutableFloatStateOf(1f)
    }
    val coroutineScope = rememberCoroutineScope();



    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)
            .clip(RoundedCornerShape(50.dp))
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(15.dp),
        value = text,
        onValueChange = { text = it },
        textStyle = TextStyle(
            fontFamily = FontFamily.Monospace
        ),
        decorationBox = { innerTextField ->
            Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically) {

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
                }, color = Color.Unspecified)
                Spacer(modifier.padding(end = 8.dp))


                Box(modifier = Modifier.weight(1f)) {
                    if (text.isEmpty()) {
                        Text(
                            text = "Search",
                            modifier = Modifier.alpha(0.5f)
                        )
                    } else {
                        Box(modifier = Modifier.alpha(searchTextAlpha)) {
                            innerTextField()
                        }


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
                })


            }

        }

    )
}
