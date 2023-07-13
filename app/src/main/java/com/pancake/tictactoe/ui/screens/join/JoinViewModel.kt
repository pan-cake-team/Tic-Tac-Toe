package com.pancake.tictactoe.ui.screens.join

import com.pancake.tictactoe.ui.base.BaseViewModel
import kotlinx.coroutines.flow.update

class JoinViewModel: BaseViewModel<JoinUiState>(JoinUiState()) {


    fun showCreateGameDialog(){
        _state.update { state ->
            state.copy(isCreateGameDialogVisible = true)
        }
    }

    fun hideCreateGameDialog(){
        _state.update { state ->
            state.copy(isCreateGameDialogVisible = false)
        }
    }

    fun showJoinGameDialog(){
        _state.update { state ->
            state.copy(isJoinGameDialogVisible = true)
        }
    }

    fun hideJoinGameDialog(){
        _state.update { state ->
            state.copy(isJoinGameDialogVisible = false)
        }
    }
}