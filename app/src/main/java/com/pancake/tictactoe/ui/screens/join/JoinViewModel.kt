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


    init {
        viewModelScope.launch {
            firebaseFire.createSession("Ameer")
        }
    }

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

    fun showJoinGameDialog(){
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
            state.copy(name = name)
        }
    }

    fun onChangeGameId(gameId: String) {
        _state.update { state ->
            state.copy(gameId = gameId)
        }
    }

    fun createGameSession() {
        //todo: call createGameSession firebase function
    }

    fun joinToGameSession() {
        _state.update { state ->
            state.copy(isJoinGameDialogVisible = false)
        }
        viewModelScope.launch {
            val isJoinSuccess = firebaseFire.joinSession(
                state.value.gameId,
                state.value.name
            )
            _state.update {
                it.copy(
                    isJoinSuccess = isJoinSuccess
                )
            }
        }

    }
}