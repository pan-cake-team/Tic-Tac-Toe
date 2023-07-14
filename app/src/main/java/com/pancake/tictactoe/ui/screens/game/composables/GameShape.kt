package com.pancake.tictactoe.ui.screens.game.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.dp
import com.pancake.tictactoe.ui.theme.Green

@Composable
fun Cross(
    modifier: Modifier = Modifier
) {
    Box(Modifier.fillMaxSize()) {
        Canvas(
            modifier = modifier
                .align(Alignment.Center)
                .size(56.dp)
                .padding(8.dp)
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

