package com.pancake.tictactoe.ui.screens.join

import com.pancake.tictactoe.ui.base.BaseUiState

data class JoinUiState(
    val isCreateGameDialogVisible: Boolean = false,
    val isJoinGameDialogVisible: Boolean = false,
) : BaseUiState