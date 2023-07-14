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
        _state.update {
            it.copy(
                playerOne = Player(buttonStatus = ButtonStatus.CROSS, buttonSelected = index)
            )
        }
    }
}