package com.pancake.tictactoe.ui.screens.game

data class GameUiState(
    val sessionId: String = "",
    var idOwnerGame: String = "Ahmed12345",
    val counter: Int = 0,
    val gameStatus: GameStatus = GameStatus.NOT_FINISH,
    val dialogState: Boolean = true,

    val playerOne: PlayerUiState = PlayerUiState(
        id = "Ameer12345",
        name = "Ameer",
        isRoundPlayer = true,
        action = ItemBoardState.CROSS,
        score = 0,
    ),
    val playerTwo: PlayerUiState = PlayerUiState(
        id = "Ahmed12345",
        name = "Ahmed",
        isRoundPlayer = false,
        action = ItemBoardState.CIRCLE,
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

) {
    fun isGameFinished(): Boolean {
        return gameStatus == GameStatus.PLAYER_TWO_WIN || gameStatus == GameStatus.PLAYER_ONE_WIN || gameStatus == GameStatus.DRAW
    }

}


data class ItemBoarderUiSate(
    var id: Int = 0,
    var state: ItemBoardState = ItemBoardState.EMPTY,
) {
    fun isActiveItemBoarderCell() = state == ItemBoardState.EMPTY
}

data class PlayerUiState(
    var id: String = "",
    var action: ItemBoardState = ItemBoardState.EMPTY,
    val name: String = "",
    var isRoundPlayer: Boolean = false,
    val score: Int = 0,
)

enum class ItemBoardState {
    EMPTY, //0
    CROSS, //1
    CIRCLE //2
}

enum class GameStatus {
    PLAYER_ONE_WIN,
    PLAYER_TWO_WIN,
    NOT_FINISH,
    DRAW,
}