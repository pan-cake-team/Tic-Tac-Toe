package com.pancake.tictactoe.domain.mapper

import com.pancake.tictactoe.data.remote.models.PlayerDto
import com.pancake.tictactoe.domain.model.Player
import com.pancake.tictactoe.ui.screens.game.ItemBoardState

fun PlayerDto.toPlayer(): Player {
    return Player(
        id = id ?: "",
        name = name ?: "",
        action = ItemBoardState.toState(action ?: "EMPTY")!!,
        isRoundPlayer = isRoundPlayer ?: false,
        score = score ?: 0,
    )
}

fun Player.toPlayerDto(): PlayerDto {
    return PlayerDto(
        id = id,
        name = name,
        action = action.name,
        isRoundPlayer = isRoundPlayer,
        score = score,
    )
}