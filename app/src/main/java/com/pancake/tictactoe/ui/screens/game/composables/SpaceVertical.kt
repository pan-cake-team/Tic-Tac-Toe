package com.pancake.tictactoe.ui.screens.game.composables

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pancake.tictactoe.ui.theme.space16
import com.pancake.tictactoe.ui.theme.space24
import com.pancake.tictactoe.ui.theme.space32
import com.pancake.tictactoe.ui.theme.space8


@Composable
fun SpacerVertical8() {
    Spacer(modifier = Modifier.height(space8))
}

@Composable
fun SpacerVertical16() {
    Spacer(modifier = Modifier.height(space16))
}

@Composable
fun SpacerVertical24() {
    Spacer(modifier = Modifier.height(space24))
}

@Composable
fun SpacerVertical32() {
    Spacer(modifier = Modifier.height(space32))
}
