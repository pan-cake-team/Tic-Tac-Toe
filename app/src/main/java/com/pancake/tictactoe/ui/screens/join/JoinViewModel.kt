package com.pancake.tictactoe.ui.screens.join

import androidx.lifecycle.viewModelScope
import com.pancake.tictactoe.data.remote.FirebaseFireStoreService
import com.pancake.tictactoe.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class JoinViewModel @Inject constructor(
    private val firebaseFire: FirebaseFireStoreService
) : BaseViewModel<JoinUiState>(JoinUiState()) {


    fun showCreateGameDialog() {
        _state.update { state ->
            state.copy(isCreateGameDialogVisible = true)
        }
    }

    fun hideCreateGameDialog() {
        _state.update { state ->
            state.copy(isCreateGameDialogVisible = false)
        }
    }

    fun showJoinGameDialog() {
        _state.update { state ->
            state.copy(isJoinGameDialogVisible = true)
        }
    }

    fun hideJoinGameDialog() {
        _state.update { state ->
            state.copy(isJoinGameDialogVisible = false)
        }
    }

    fun onChangeName(name: String) {
        _state.update { state ->
            state.copy(PlayerName = name)
        }
    }

    fun onChangeGameId(gameId: String) {
        _state.update { state ->
            state.copy(gameId = gameId)
        }
    }

    fun createGameSession() {
        _state.update { state ->
            state.copy(isCreateGameDialogVisible = false)
        }
        viewModelScope.launch {
            firebaseFire.createSession(state.value.PlayerName)
        }
    }

    fun joinToGameSession() {
        _state.update { state ->
            state.copy(isJoinGameDialogVisible = false)
        }
        viewModelScope.launch {
            val isJoinSuccess = firebaseFire.joinSession(
                state.value.gameId,
                state.value.PlayerName
            )
            _state.update {
                it.copy(
                    isJoinSuccess = isJoinSuccess
                )
            }
        }

    }
}