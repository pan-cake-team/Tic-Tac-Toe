package com.pancake.tictactoe.ui.screens.game

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor() : ViewModel() {
    private val _state = MutableStateFlow(GameUiState())
    val state = _state.asStateFlow()


    fun onClickGameBoard(index: Int) {
        val updatedBoardState = _state.value.boarder.toMutableList().apply {
            this[index] = this[index].copy(
                state = getUserAction(),
                isActive = false,
            )
        }

        updateRoundPlayer()
        _state.update {
            it.copy(
                boarder = updatedBoardState
            )
        }
    }

    private fun updateRoundPlayer() {
        val player = _state.value

        if (player.playerOne.isRoundPlayer) {
            _state.update {
                it.copy(
                    playerOne = it.playerOne.copy(
                        isRoundPlayer = false
                    ),
                    playerTwo = it.playerTwo.copy(
                        isRoundPlayer = true
                    )
                )
            }
        } else {
            _state.update {
                it.copy(
                    playerOne = it.playerOne.copy(
                        isRoundPlayer = true
                    ),
                    playerTwo = it.playerTwo.copy(
                        isRoundPlayer = false
                    )
                )
            }
        }

    }

    private fun getUserAction(): ItemBoardState {
        val player = _state.value
        if (player.playerOne.isRoundPlayer) {
            return player.playerOne.action

        }

        if (player.playerTwo.isRoundPlayer) {
            return player.playerTwo.action
        }
        return ItemBoardState.EMPTY
    }


    private fun getTheWinner(index: Int): ItemBoardState {
        return when (_state.value.boarder[index].state) {
            ItemBoardState.CROSS -> if (checkIfWin(ItemBoardState.CROSS)) ItemBoardState.CROSS else ItemBoardState.EMPTY
            ItemBoardState.CIRCLE -> if (checkIfWin(ItemBoardState.CIRCLE)) ItemBoardState.CIRCLE else ItemBoardState.EMPTY
            else -> ItemBoardState.EMPTY
        }
    }

    private fun checkIfWin(itemBoardState: ItemBoardState): Boolean {
        val listItemBorder = _state.value.boarder

        for (i in listItemBorder.indices step 3) {
            if (listItemBorder[i].state == itemBoardState && listItemBorder[i + 1].state == itemBoardState && listItemBorder[i + 2].state == itemBoardState) {
                return true
            }
        }

        for (i in 0 until 3) {
            if (listItemBorder[i].state == itemBoardState && listItemBorder[i + 3].state == itemBoardState && listItemBorder[i + 6].state == itemBoardState) {
                return true
            }
        }

        if (listItemBorder[0].state == itemBoardState && listItemBorder[4].state == itemBoardState && listItemBorder[8].state == itemBoardState) {
            return true
        }
        if (listItemBorder[2].state == itemBoardState && listItemBorder[4].state == itemBoardState && listItemBorder[6].state == itemBoardState) {
            return true
        }

        return false
    }
}