package com.pancake.tictactoe.ui.screens.game.composables

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pancake.tictactoe.ui.screens.game.GameUiState
import com.pancake.tictactoe.ui.screens.game.ItemBoardState
import com.pancake.tictactoe.ui.screens.game.PlayerUiState
import com.pancake.tictactoe.ui.screens.game.ScoreText
import com.pancake.tictactoe.ui.theme.space16

@Composable
fun PlayerInfo(state: GameUiState) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = space16, end = space16, bottom = space16),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        NamePlayer(state.playerOne)
        ScoreText(text = "${state.playerOne.score} - ${state.playerTwo.score}")
        NamePlayer(state.playerTwo)
    }
}


@Preview(showBackground = true)
@Composable
private fun PlayerInfoPreview() {
    PlayerInfo(
        GameUiState(
            playerOne = PlayerUiState(
                id = "Ameer12345",
                name = "Ameer",
                isRoundPlayer = false,
                action = ItemBoardState.CIRCLE,
                score = 1,
            ),
            playerTwo = PlayerUiState(
                id = "Ahmed12345",
                name = "Ahmed",
                isRoundPlayer = true,
                action = ItemBoardState.CROSS,
                score = 0,
            ),
        )
    )
}