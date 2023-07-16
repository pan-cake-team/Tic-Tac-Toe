package com.pancake.tictactoe.domain.mapper

import com.pancake.tictactoe.data.remote.models.GameDto
import com.pancake.tictactoe.domain.model.Game
import com.pancake.tictactoe.domain.model.Player
import com.pancake.tictactoe.ui.screens.game.GameStatus
import com.pancake.tictactoe.ui.screens.game.ItemBoardState


fun GameDto.toGame(): Game {
    val player = Player(
        id = "",
        action = ItemBoardState.EMPTY,
        name = "",
        isRoundPlayer = false,
        score = 0,
    )
   return Game(
       sessionId = sessionId ?: "",
       idOwnerGame = idOwnerGame ?: "",
       counter = counter ?: 0,
       gameStatus = GameStatus.toGameStatus(gameStatus ?: "NOT_FINISH")!!,
       dialogState = dialogState ?: true,
       playerOne = playerOne?.toPlayer() ?: player,
       playerTwo = playerTwo?.toPlayer() ?: player,
       boarder = boarder?.toItemBoardCell() ?: emptyList()
   )
}

fun Game.toGameDto(): GameDto {
    return GameDto(
        sessionId = sessionId,
        idOwnerGame = idOwnerGame,
        counter = counter,
        gameStatus = gameStatus.name,
        dialogState = dialogState,
        playerOne.toPlayerDto(),
        playerTwo.toPlayerDto(),
        boarder.toMapItemBoardCell(),
    )
}