package com.pancake.tictactoe.ui.screens.game.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.pancake.tictactoe.ui.screens.game.ItemBoardState
import com.pancake.tictactoe.ui.screens.game.PlayerUiState
import com.pancake.tictactoe.ui.theme.mainTypography
import com.pancake.tictactoe.ui.uitll.extensions.getColorState

@Composable
fun PlayerName(state: PlayerUiState) {
    Text(
        text = state.name,
        style = mainTypography.titleLarge,
        color = state.action.getColorState(state.isRoundPlayer)
    )
}

@Preview(showBackground = true)
@Composable
private fun PlayerNameRoundActivePreview() {
    PlayerName(
        PlayerUiState(
            id = "Ameer12345",
            name = "Ameer",
            isRoundPlayer = true,
            action = ItemBoardState.CIRCLE,
            score = 0,
        ),
    )
}

@Preview(showBackground = true)
@Composable
private fun PlayerNameNotRoundUserPreview() {
    PlayerName(
        PlayerUiState(
            name = "Ameer",
            isRoundPlayer = false,
            action = ItemBoardState.CIRCLE,
        ),
    )
}
