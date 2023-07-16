package com.pancake.tictactoe.ui.screens.game

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pancake.tictactoe.domain.usecase.UpdateGameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class GameViewModel @Inject constructor(
    gameUseCase: UpdateGameUseCase,
) : ViewModel() {
    private val _state = MutableStateFlow(GameUiState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch {
            gameUseCase("165dccc522ae")
        }

    }

    fun onClickGameBoard(index: Int) {
        val updatedBoardState = _state.value.boarder.toMutableList().apply {
            this[index] = this[index].copy(
                state = getUserAction(),
            )
        }

        _state.update {
            it.copy(
                boarder = updatedBoardState,
                counter = _state.value.counter + 1
            )
        }

        val gameStatus = getGameStatus()
        _state.update { it.copy(gameStatus = gameStatus) }

        updateScore(gameStatus)
        updateRoundPlayer()
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

    private fun updateScore(gameStatus: GameStatus) {
        when (gameStatus) {
            GameStatus.PLAYER_ONE_WIN -> _state.update {
                it.copy(
                    playerOne = _state.value.playerOne.copy(
                        score = _state.value.playerOne.score + 1,
                    ),
                )
            }

            GameStatus.PLAYER_TWO_WIN -> _state.update {
                it.copy(
                    playerTwo = _state.value.playerTwo.copy(
                        score = _state.value.playerTwo.score + 1,
                    ),
                )
            }

            else -> {}
        }
    }

    private fun getGameStatus(): GameStatus {
        val player = _state.value
        return if (player.playerOne.isRoundPlayer) {
            when (checkIfWin(player.playerOne.action)) {
                true -> {
                    GameStatus.PLAYER_ONE_WIN
                }

                false -> if (player.counter != 9) GameStatus.NOT_FINISH else GameStatus.DRAW
            }
        } else {
            when (checkIfWin(player.playerTwo.action)) {
                true -> {
                    GameStatus.PLAYER_TWO_WIN
                }

                false -> if (player.counter != 9) GameStatus.NOT_FINISH else GameStatus.DRAW
            }
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

    fun onClickPlayAgain() {
        val itemsBoard = mutableListOf<ItemBoarderUiSate>()
        for (i in 0..8) {
            itemsBoard.add(ItemBoarderUiSate(id = i))
        }
        _state.update {
            it.copy(
//                boarder = itemsBoard,
                counter = 0,
                gameStatus = GameStatus.NOT_FINISH,
                dialogState = true,
            )
        }
    }

    fun onClickDismissDialog() {
        _state.update { it.copy(dialogState = false) }
    }
}