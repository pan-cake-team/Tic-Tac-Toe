package com.pancake.tictactoe.ui.screens.game.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.pancake.tictactoe.R
import com.pancake.tictactoe.ui.screens.game.GameStatus
import com.pancake.tictactoe.ui.screens.game.GameUiState

@Composable
fun gameStatusTitle(state: GameUiState, playerName: String): String {
    return when (state.gameStatus) {
        GameStatus.PLAYER_ONE_WIN -> if (state.playerOne.name == playerName) stringResource(R.string.you_win) else stringResource(
            R.string.you_lose
        )

        GameStatus.PLAYER_TWO_WIN -> if (state.playerTwo.name == playerName) stringResource(R.string.you_win) else stringResource(
            R.string.you_lose
        )

        GameStatus.DRAW -> stringResource(R.string.draw)
        else -> ""
    }
}