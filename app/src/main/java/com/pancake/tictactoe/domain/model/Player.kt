package com.pancake.tictactoe.domain.model

import com.pancake.tictactoe.ui.screens.game.ItemBoardState


data class Player(
    var id: String,
    var action: ItemBoardState,
    val name: String,
    var isRoundPlayer: Boolean,
    val score: Int,
)