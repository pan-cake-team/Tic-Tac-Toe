package com.pancake.tictactoe.ui.screens.game

data class GameUiState(
    val sessionId: String = "",
    val isTurn: Boolean = true,
    var idOwnerGame: String = "Ahmed12345",

    val playerOne: PlayerUiState = PlayerUiState(
        id = "Ameer12345",
        name = "Ameer",
        isRoundPlayer = false,
        action = ItemBoardState.CIRCLE,
        score = 0,
    ),
    val playerTwo: PlayerUiState = PlayerUiState(
        id = "Ahmed12345",
        name = "Ahmed",
        isRoundPlayer = true,
        action = ItemBoardState.CROSS,
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
    var state: ItemBoardState = ItemBoardState.Empty,
    var isActive: Boolean = true,
    var idUserClicked: String = "",
)

data class PlayerUiState(
    var id: String = "",
    var action: ItemBoardState = ItemBoardState.Empty,
    val name: String = "",
    var isRoundPlayer: Boolean = false,
    val score: Int = 0,
)

enum class ItemBoardState {
    Empty,
    CROSS,
    CIRCLE
}