package com.pancake.tictactoe.ui.screens.game.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.pancake.tictactoe.ui.screens.game.GameUiState
import com.pancake.tictactoe.ui.screens.game.ScoreText
import com.pancake.tictactoe.ui.theme.space16


@Composable
fun GameScore(state: GameUiState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = space16, end = space16, bottom = space16),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        PlayerName(state.playerOne)
        ScoreText(text = "${state.playerOne.score} - ${state.playerTwo.score}")
        PlayerName(state.playerTwo)
    }
}
