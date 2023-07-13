package com.pancake.tictactoe.ui.screens.game.composables

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pancake.tictactoe.ui.theme.Green
import com.pancake.tictactoe.ui.theme.Orange
import com.pancake.tictactoe.ui.theme.space56
import com.pancake.tictactoe.ui.theme.space8

@Composable
@Preview
fun Cross(
    modifier: Modifier = Modifier
) {
    Canvas(
        modifier = modifier
            .size(space56)
            .padding(space8)
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

@Composable
@Preview
fun Circle(
    modifier: Modifier = Modifier
){
    Canvas(
        modifier = modifier
            .size(56.dp)
            .padding(8.dp)
    ) {
        drawCircle(
            color = Orange,
            style = Stroke(40f)
        )
    }
}