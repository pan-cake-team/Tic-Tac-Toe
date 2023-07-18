package com.pancake.tictactoe.ui.screens.game.mapper

import com.pancake.tictactoe.domain.model.Game
import com.pancake.tictactoe.domain.model.ItemBoarder
import com.pancake.tictactoe.domain.model.Player
import com.pancake.tictactoe.ui.screens.game.GameUiState
import com.pancake.tictactoe.ui.screens.game.ItemBoarderUiSate
import com.pancake.tictactoe.ui.screens.game.PlayerUiState


fun Player.toPlayerUiState(): PlayerUiState {
    return PlayerUiState(
        id = id,
        name = name,
        isRoundPlayer = isRoundPlayer,
        action = action,
        score = score
    )
}

fun GameUiState.toGame(): Game = Game(
    sessionId = sessionId,
    idOwnerGame = idOwnerGame,
    counter = counter,
    gameStatus = gameStatus,
    dialogState = dialogState,
    playerOne = playerOne.toPlayer(),
    playerTwo = playerTwo.toPlayer(),
    boarder = boarder.map { it.toItemBoarder() }
)

private fun PlayerUiState.toPlayer() = Player(
    id = id,
    name = name,
    isRoundPlayer = isRoundPlayer,
    action = action,
    score = score
)

private fun ItemBoarderUiSate.toItemBoarder() = ItemBoarder(
    id = id,
    state = state
)

fun ItemBoarder.toItemBoarderUiState(): ItemBoarderUiSate {
    return ItemBoarderUiSate(
        id = id,
        state = state
    )

}

