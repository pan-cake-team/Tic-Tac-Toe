package com.pancake.tictactoe.data.remote.models

data class Session(
    val id: String = "",
    val players: MutableList<PlayerSession> = mutableListOf()
)