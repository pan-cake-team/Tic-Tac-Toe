package com.pancake.tictactoe.ui.screens.game.composables

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pancake.tictactoe.ui.theme.Orange


@Composable
fun CircleShape(
    modifier: Modifier = Modifier
) {
    val radius = 56F
    val animateFloat = remember { Animatable(0f) }
    LaunchedEffect(animateFloat) {
        animateFloat.animateTo(
            targetValue = 1f,
            animationSpec = tween(durationMillis = 500, easing = LinearEasing)
        )
    }

    Box(Modifier.fillMaxSize()) {
        Canvas(
            modifier = modifier
                .align(Alignment.Center)
                .size(56.dp)
                .padding(8.dp)
        ) {

            drawArc(
                color = Orange,
                startAngle = 0f,
                sweepAngle = 360f * animateFloat.value,
                useCenter = false,
                size = Size(radius * 2, radius * 2),
                style = Stroke(40.0f)
            )
        }
    }

}


@Composable
@Preview(showBackground = true)
private fun CircleShapePreview() {
    CircleShape()
}