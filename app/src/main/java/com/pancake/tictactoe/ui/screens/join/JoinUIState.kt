package com.pancake.tictactoe.ui.screens.join

import com.pancake.tictactoe.ui.base.BaseUiState

data class JoinUiState(
    val PlayerName:String="",
    val gameId: String = "",
    val isCreateGameDialogVisible: Boolean = false,
    val isJoinGameDialogVisible: Boolean = false,
    val isJoinSuccess: Boolean = false,
) : BaseUiState