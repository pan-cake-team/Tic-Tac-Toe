package com.pancake.tictactoe.data.remote.exceptions


data class SessionJoiningException(override val message: String?) : Exception(message)
