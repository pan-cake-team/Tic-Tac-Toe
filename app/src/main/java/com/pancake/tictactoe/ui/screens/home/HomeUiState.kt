package com.pancake.tictactoe.ui.screens.home

import com.pancake.tictactoe.ui.base.BaseUiState

data class HomeUiState(
    val playerName:String="",
    val gameId: String = "",
    val isNameEmpty :Boolean = false,
    val isGameIdEmpty :Boolean = false,
    val isCreateGameDialogVisible: Boolean = false,
    val isJoinGameDialogVisible: Boolean = false,
    val isJoinSuccess: Boolean = false,
    val isCreateSuccess: Boolean = false,
) : BaseUiState