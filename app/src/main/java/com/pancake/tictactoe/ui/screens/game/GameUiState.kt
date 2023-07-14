package com.pancake.tictactoe.ui.screens.game

import androidx.compose.ui.graphics.Color
import com.pancake.tictactoe.ui.theme.Green
import com.pancake.tictactoe.ui.theme.Orange
import com.pancake.tictactoe.ui.theme.textPrimary

data class GameUiState(
    val sessionId: String = "",
    val isTurn: Boolean = true,
    var idOwnerGame: String = "Ahmed12345",

    val playerOne: PlayerUiState = PlayerUiState(
        id = "Ameer12345",
        name = "Ameer",
        isRoundPlayer = false,
        action = ButtonStatus.CIRCLE,
        score = 0,
    ),
    val playerTwo: PlayerUiState = PlayerUiState(
        id = "Ahmed12345",
        name = "Ahmed",
        isRoundPlayer = true,
        action = ButtonStatus.CROSS,
        score = 0,
    ),
    val boarder: List<ItemBoarderUiSate> = listOf(
        ItemBoarderUiSate(id = 1),
        ItemBoarderUiSate(id = 2),
        ItemBoarderUiSate(id = 3),

        ItemBoarderUiSate(id = 4),
        ItemBoarderUiSate(id = 5),
        ItemBoarderUiSate(id = 6),

        ItemBoarderUiSate(id = 7),
        ItemBoarderUiSate(id = 8),
        ItemBoarderUiSate(id = 9),
    ),
    val isFinished: Boolean = false,
)

data class ItemBoarderUiSate(
    var id: Int = 0,
    var state: ButtonStatus = ButtonStatus.Empty,
    var isActive: Boolean = true,
    var idUserClicked: String = "",
)

data class PlayerUiState(
    var id: String = "",
    var action: ButtonStatus = ButtonStatus.Empty,
    val name: String = "",
    var isRoundPlayer: Boolean = false,
    val score: Int = 0,
)
enum class ButtonStatus {
    Empty,
    CROSS,
    CIRCLE
}

fun ButtonStatus.getColor(stateUser: Boolean): Color {
    if (this == ButtonStatus.CROSS && stateUser) {
        return Green
    }
    if (this == ButtonStatus.CIRCLE && stateUser) {
        return  Orange
    }
    return textPrimary

}