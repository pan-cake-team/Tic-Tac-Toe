package com.pancake.tictactoe.data.remote.exceptions


data class SessionCreationException(override val message: String?) : Exception(message)
