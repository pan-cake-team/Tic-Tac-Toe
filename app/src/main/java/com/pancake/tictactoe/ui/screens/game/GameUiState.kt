package com.pancake.tictactoe.ui.screens.game

data class GameUiState(
    val sessionId: String = "",
    val isTurn: Boolean = true,
    val playerOne: Player = Player(),
    val playerTwo: Player = Player(),
    val isFinished: Boolean = false,
)

data class Player(
    val name: String = "",
    val score: Int = 0,
    val buttonStatus: ButtonStatus = ButtonStatus.Empty,
    val buttonSelected: Int = -1,
)

enum class ButtonStatus {
    Empty,
    CROSS,
    CIRCLE
}