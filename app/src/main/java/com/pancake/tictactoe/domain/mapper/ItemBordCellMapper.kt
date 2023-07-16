package com.pancake.tictactoe.domain.mapper

import com.pancake.tictactoe.domain.model.ItemBoarder
import com.pancake.tictactoe.ui.screens.game.ItemBoardState


fun Map<String, String>.toItemBoardCell(): List<ItemBoarder> {
    val itemList = mutableListOf<ItemBoarder>()

    for ((key, value) in this) {
        val id = key.toInt()
       val state = ItemBoardState.toState(value)!!

        itemList.add(ItemBoarder(id, state))
    }

    return itemList
}