@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.pancake.tictactoe.ui.screens.game.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.pancake.tictactoe.ui.screens.game.GameStatus
import com.pancake.tictactoe.ui.screens.game.GameUiState
import com.pancake.tictactoe.ui.screens.game.ItemBoardState
import com.pancake.tictactoe.ui.screens.game.ItemBoarderUiSate
import com.pancake.tictactoe.ui.theme.Brand
import com.pancake.tictactoe.ui.theme.Gray
import com.pancake.tictactoe.ui.theme.backGround


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GameBoard(
    state: GameUiState,
    onClick: (Int) -> Unit
) {
    LazyVerticalGrid(
        cells = GridCells.Fixed(3)
    ) {
        items(count = state.boarder.size) { index ->
            val itemBoardState = state.boarder[index]
            val background = when (state.gameStatus) {
                GameStatus.PLAYER_ONE_WIN -> {
                    if (state.playerOne.action == itemBoardState.state)
                        Brand else backGround
                }

                GameStatus.PLAYER_TWO_WIN -> {
                    if (state.playerTwo.action == itemBoardState.state)
                        Brand else backGround
                }

                else -> backGround
            }
            GameBoardItem(
                itemBoardState,
                isGameFinished = state.isGameFinished(),
                background = background,
                onClick = { onClick(index) },
            )
        }
    }
}

@Composable
fun GameBoardItem(
    state: ItemBoarderUiSate,
    isGameFinished: Boolean = false,
    background: Color = backGround,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .background(background)
            .border(width = 1.dp, color = Gray)
            .clickable(
                onClick = onClick,
                enabled = if (isGameFinished) false else state.isActive
            )
            .padding(26.dp),
    ) {
        when (state.state) {
            ItemBoardState.CIRCLE -> CircleShape()
            ItemBoardState.CROSS -> CrossShape()
            else -> Spacer(modifier = Modifier.size(56.dp))
        }
    }
}

