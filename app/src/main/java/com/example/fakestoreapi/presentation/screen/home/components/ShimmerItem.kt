package com.example.fakestoreapi.presentation.screen.home.components

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.unit.dp

@Composable
fun ShimmerListItem(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .padding(
                top = 8.dp,
                start = 8.dp,
                end = 8.dp,
                bottom = 8.dp
            ),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        Box(
            modifier = modifier
                .fillMaxWidth()
                .height(170.dp)
                .shimmerBackground1(RoundedCornerShape(10.dp)),
        )

        Text(
            text = "",
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .width(150.dp)
                .shimmerBackground1(RoundedCornerShape(4.dp)),
            maxLines = 1,

            )
        Text(
            text = "",
            modifier = modifier
                .align(Alignment.CenterHorizontally)
                .width(60.dp)
                .shimmerBackground1(RoundedCornerShape(4.dp)),
        )
    }
}

fun Modifier.shimmerBackground1(shape: Shape = RectangleShape): Modifier = composed {
    val transition = rememberInfiniteTransition()

    val translateAnimation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 400f,
        animationSpec = infiniteRepeatable(
            tween(durationMillis = 1500, easing = LinearOutSlowInEasing),
            RepeatMode.Restart
        ),
    )
    val shimmerColors = listOf(
        Color.LightGray.copy(alpha = 0.9f),
        Color.LightGray.copy(alpha = 0.4f),
    )
    val brush = Brush.linearGradient(
        colors = shimmerColors,
        start = Offset(translateAnimation, translateAnimation),
        end = Offset(translateAnimation + 100f, translateAnimation + 100f),
        tileMode = TileMode.Mirror,
    )
    return@composed this.then(background(brush, shape))
}

//fun Modifier.shimmerBackground(shape: Shape = RectangleShape): Modifier = composed {
//    var size by remember {
//        mutableStateOf(IntSize.Zero)
//    }
//    val transition = rememberInfiniteTransition()
//    val startOffsetX by transition.animateFloat(
//        initialValue = -2 * size.width.toFloat(),
//        targetValue = 2 * size.width.toFloat(),
//        animationSpec = infiniteRepeatable(
//            animation = tween(1000)
//        )
//    )
//
//    background(
//        brush = Brush.linearGradient(
//            colors = listOf(
//                Color(0xFFB8B5B5),
//                Color(0xFF8F8B8B),
//                Color(0xFFB8B5B5),
//            ),
//            start = Offset(startOffsetX, 0f),
//            end = Offset(startOffsetX + size.width.toFloat(), size.height.toFloat())
//        )
//    )
//        .onGloballyPositioned {
//            size = it.size
//        }
//}