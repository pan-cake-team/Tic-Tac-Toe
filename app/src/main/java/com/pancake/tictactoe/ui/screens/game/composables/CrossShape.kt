package com.pancake.tictactoe.ui.screens.game.composables

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
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
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pancake.tictactoe.ui.theme.Green
import com.pancake.tictactoe.ui.theme.sizeItemBoard
import com.pancake.tictactoe.ui.theme.space8

@Composable
fun CrossShape(
    modifier: Modifier = Modifier
) {
    val crossRotation = remember { Animatable(0f) }

    LaunchedEffect(Unit) {
        crossRotation.animateTo(90f, animationSpec = spring())
    }

    Box(Modifier.fillMaxSize()) {
        Canvas(
            modifier = modifier
                .align(Alignment.Center)
                .size(sizeItemBoard)
                .padding(space8)
                .rotate(crossRotation.value)
        ) {
            drawLine(
                color = Green,
                strokeWidth = 40f,
                start = Offset(x = 0f, y = 0f),
                end = Offset(x = size.width, y = size.height)
            )
            drawLine(
                color = Green,
                strokeWidth = 40f,
                start = Offset(x = 0f, y = size.height),
                end = Offset(x = size.width, y = 0f)
            )
        }
    }
}

@Preview
@Composable
private fun CrossPreview() {
    CrossShape()
}