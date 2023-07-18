package com.pancake.tictactoe.ui.screens.home

import androidx.lifecycle.viewModelScope
import com.pancake.tictactoe.data.remote.FirebaseFireStoreService
import com.pancake.tictactoe.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val firebaseFire: FirebaseFireStoreService
) : BaseViewModel<HomeUiState>(HomeUiState()) {


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
            state.copy(playerName = name)
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
            val gameId = firebaseFire.createSession(state.value.playerName)
            if (gameId != SESSION_CREATION_FAILED) {
                _state.update { it.copy(isCreateSuccess = true, gameId =gameId ) }
            }
        }
    }

    fun joinToGameSession() {
        _state.update { state ->
            state.copy(isJoinGameDialogVisible = false)
        }
        viewModelScope.launch {
            val isJoinSuccess = firebaseFire.joinSession(
                state.value.gameId,
                state.value.playerName
            )
            _state.update {
                it.copy(
                    isJoinSuccess = isJoinSuccess
                )
            }
        }

    }

    private companion object {
        const val SESSION_CREATION_FAILED = "Session creation failed!"
    }
}