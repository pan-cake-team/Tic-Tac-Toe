package com.pancake.tictactoe.ui.screens.game.composables

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.pancake.tictactoe.R
import com.pancake.tictactoe.ui.screens.game.GameStatus
import com.pancake.tictactoe.ui.screens.game.GameUiState

@Composable
fun gameStatusSubTitle(state: GameUiState, playerId: String): String {
    return when (state.gameStatus) {
        GameStatus.PLAYER_ONE_WIN -> if (state.playerOne.id == playerId) stringResource(R.string.win_message) else stringResource(
            R.string.lose_message
        )

        GameStatus.PLAYER_TWO_WIN -> if (state.playerTwo.id == playerId) stringResource(R.string.win_message) else stringResource(
            R.string.lose_message
        )

        GameStatus.DRAW -> stringResource(R.string.draw_message)
        else -> ""
    }
}