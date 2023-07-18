package com.pancake.tictactoe.domain.mapper

import com.pancake.tictactoe.domain.model.ItemBoarder
import com.pancake.tictactoe.ui.screens.game.ItemBoardState


fun Map<String, String>.toItemBoardCell(): List<ItemBoarder> {
    return this.map { (key, value) ->
        val id = key.toInt()
        val state = ItemBoardState.toState(value) ?: throw IllegalArgumentException("Invalid state: $value")
        ItemBoarder(id, state)
    }
}
fun List<ItemBoarder>.toMapItemBoardCell(): Map<String, String> {
    return this.associate { itemBoarder ->
        itemBoarder.id.toString() to itemBoarder.state.name
    }
}