package com.pancake.tictactoe.data.remote.models

import com.pancake.tictactoe.data.remote.FirebaseFireStoreService.Companion.generateRandomId


data class PlayerSession(
    val id: String = generateRandomId(),
    val name: String = ""
)
