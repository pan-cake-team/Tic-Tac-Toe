package com.pancake.tictactoe.domain.model

import com.pancake.tictactoe.ui.screens.game.GameStatus

data class Game(
    val sessionId: String,
    var idOwnerGame: String,
    val counter: Int,
    val gameStatus: GameStatus,
    val dialogState: Boolean,
    val playerOne: Player,
    val playerTwo: Player,
    val boarder: List<ItemBoarder>,
)


