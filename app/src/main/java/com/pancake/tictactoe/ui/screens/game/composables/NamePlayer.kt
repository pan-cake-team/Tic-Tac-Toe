package com.pancake.tictactoe.ui.screens.game.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.pancake.tictactoe.ui.screens.game.ItemBoardState
import com.pancake.tictactoe.ui.screens.game.PlayerUiState
import com.pancake.tictactoe.ui.theme.mainTypography
import com.pancake.tictactoe.ui.uitll.extensions.getColorState

@Composable
fun NamePlayer(
    state: PlayerUiState,
    modifier: Modifier = Modifier
) {
    Text(
        text = state.name,
        modifier = modifier,
        style = mainTypography.titleLarge,
        color = state.action.getColorState(state.isRoundPlayer)
    )
}


@Composable
@Preview(showBackground = true)
private fun NamePlayerRoundActivePreview() {
    NamePlayer(
        PlayerUiState(
            name = "Ameer",
            isRoundPlayer = true,
            action = ItemBoardState.CIRCLE,
        ),
    )
}


@Composable
@Preview(showBackground = true)
private fun NamePlayerNotRoundUserPreview() {
    NamePlayer(
        PlayerUiState(
            name = "Ameer",
            isRoundPlayer = false,
            action = ItemBoardState.CIRCLE,
        ),
    )
}
