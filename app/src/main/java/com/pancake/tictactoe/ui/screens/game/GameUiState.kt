package com.pancake.tictactoe.ui.screens.game

data class GameUiState(
    val sessionId: String = "",
    var idOwnerGame: String = "",
    val counter: Int = 0,
    val gameStatus: GameStatus = GameStatus.NOT_FINISH,
    val dialogState: Boolean = true,
    val playerOne: PlayerUiState = PlayerUiState(),
    val playerTwo: PlayerUiState = PlayerUiState(),
    val boarder: List<ItemBoarderUiSate> = emptyList(),
) {
    fun isGameFinished(): Boolean {
        return gameStatus == GameStatus.PLAYER_TWO_WIN
                || gameStatus == GameStatus.PLAYER_ONE_WIN
                || gameStatus == GameStatus.DRAW
    }

}


data class ItemBoarderUiSate(
    var id: Int = 0,
    var state: ItemBoardState = ItemBoardState.EMPTY,
    var isActive: Boolean = true,
)

data class PlayerUiState(
    var id: String = "",
    var action: ItemBoardState = ItemBoardState.EMPTY,
    val name: String = "",
    var isRoundPlayer: Boolean = false,
    val score: Int = 0,
)

enum class ItemBoardState {
    EMPTY,
    CROSS,
    CIRCLE;

    companion object {
        fun toState(value: String): ItemBoardState? {
            return try {
                ItemBoardState.valueOf(value)
            } catch (e: IllegalArgumentException) {
                null
            }
        }
    }
}

enum class GameStatus {
    PLAYER_ONE_WIN,
    PLAYER_TWO_WIN,
    NOT_FINISH,
    DRAW;

    companion object {
        fun toGameStatus(value: String): GameStatus? {
            return try {
                valueOf(value)
            } catch (e: IllegalArgumentException) {
                null
            }
        }
    }
}