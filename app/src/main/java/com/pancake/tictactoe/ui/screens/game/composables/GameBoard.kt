@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.pancake.tictactoe.ui.screens.game.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.pancake.tictactoe.ui.screens.game.ButtonStatus
import com.pancake.tictactoe.ui.screens.game.GameUiState
import com.pancake.tictactoe.ui.theme.Gray
import kotlinx.coroutines.flow.MutableStateFlow


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GameBoard(onClick: (Int) -> Unit, state: GameUiState) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3)
    ) {
        items(count = 9) {
            val symbol = remember { MutableStateFlow(getTheSuitableSymbol(state,it)) }
            symbol.value = getTheSuitableSymbol(state,it)
            GameBoardItem(onClick = { onClick(it) }, symbol.value, state.isTurn)
        }
    }
}

@Composable
fun GameBoardItem(onClick: () -> Unit, symbol: String, enable: Boolean) {
    Box(
        modifier = Modifier
            .border(width = 1.dp, color = Gray)
            .clickable(onClick = onClick, enabled = enable)
            .padding(26.dp),
    ) {
        when (symbol) {
            "o" -> Circle(modifier = Modifier.align(Alignment.Center))
            "x" -> Cross(modifier = Modifier.align(Alignment.Center))
            else -> Spacer(modifier = Modifier.size(56.dp))
        }
    }
}

fun getTheSuitableSymbol(state: GameUiState, index: Int): String {
    var symbol = ""
    if (state.playerOne.buttonSelected == index) {
        symbol = when (state.playerOne.buttonStatus) {
            ButtonStatus.CROSS -> "x"
            ButtonStatus.CIRCLE -> "o"
            ButtonStatus.Empty -> ""
        }
    } else if (state.playerTwo.buttonSelected == index) {
        symbol = when (state.playerTwo.buttonStatus) {
            ButtonStatus.CROSS -> "x"
            ButtonStatus.CIRCLE -> "o"
            ButtonStatus.Empty -> ""
        }
    }
    return symbol
}