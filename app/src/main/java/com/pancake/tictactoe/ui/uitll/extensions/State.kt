package com.pancake.tictactoe.ui.uitll.extensions

import androidx.compose.ui.graphics.Color
import com.pancake.tictactoe.ui.screens.game.ItemBoardState
import com.pancake.tictactoe.ui.theme.Green
import com.pancake.tictactoe.ui.theme.Orange
import com.pancake.tictactoe.ui.theme.textPrimary

fun ItemBoardState.getColorState(stateUser: Boolean): Color {
    if (this == ItemBoardState.CROSS && stateUser) {
        return Green
    }
    if (this == ItemBoardState.CIRCLE && stateUser) {
        return Orange
    }
    return textPrimary

}