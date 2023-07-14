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
        val player = _state.value;

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
        val player = _state.value;
        if (player.playerOne.isRoundPlayer) {
            return player.playerOne.action

        }

        if (player.playerTwo.isRoundPlayer) {
            return player.playerTwo.action
        }
        return ItemBoardState.Empty
    }
}