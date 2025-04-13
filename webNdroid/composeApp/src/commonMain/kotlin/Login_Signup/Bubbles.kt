package Login_Signup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.unit.dp
import models.ResponsiveUi

@Composable
fun TopBubbles(
    ui: ResponsiveUi
) {
    BoxWithConstraints {
        if (ui.isMobile) {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {

                /* Left Black Box */
                Box(
                    modifier = Modifier
                        .height(400.dp)
                        .width(320.dp)
                        .offset(-(25.dp), -(180.dp))
                        .graphicsLayer {
                            rotationY = 15f
                        }
                        .clip(RoundedCornerShape(88.dp))
                        .background(ui.backgroundColor)
                )
                /* Right Black Box */
                Box(
                    modifier = Modifier
                        .size(400.dp)
                        .offset(50.dp, -(190.dp))
                        .graphicsLayer {
                            rotationZ = 15f
                        }
                        .clip(RoundedCornerShape(88.dp))
                        .background(ui.backgroundColor)
                )
                /*Orange Box*/
                Box(
                    modifier = Modifier
                        .width(320.dp)
                        .height(400.dp)
                        .offset(x = 20.dp, y = -(180.dp))
                        .graphicsLayer {
                            rotationZ = 15f
                        }
                        .clip(RoundedCornerShape(88.dp))
                        .background(ui.contrastColor)
                )
            }
        } else {
            Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
                /* Left Black Box */
                Box(
                    modifier = Modifier
                        .size(500.dp)
                        .offset(-(120.dp), -(180.dp))
                        .graphicsLayer {
                            rotationY = 15f
                        }
                        .clip(RoundedCornerShape(88.dp))
                        .background(ui.backgroundColor)
                )
                /* Right Black Box */
                Box(
                    modifier = Modifier
                        .size(500.dp)
                        .offset(120.dp, -(190.dp))
                        .graphicsLayer {
                            rotationZ = 15f
                        }
                        .clip(RoundedCornerShape(88.dp))
                        .background(ui.backgroundColor)
                )
                /*Orange Box*/
                Box(
                    modifier = Modifier
                        .size(500.dp)
                        .offset(y = -(200.dp))
                        .graphicsLayer {
                            rotationZ = 15f
                        }
                        .clip(RoundedCornerShape(88.dp))
                        .background(ui.contrastColor)
                )
            }

        }
    }

}

