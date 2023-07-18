package com.pancake.tictactoe.data.remote.response

import com.google.gson.annotations.SerializedName


data class GameDto(
    @SerializedName("sessionId")
    val sessionId: String?,
    @SerializedName("idOwnerGame")
    var idOwnerGame: String?,
    @SerializedName("counter")
    val counter: Int = 0,
    @SerializedName("gameStatus")
    val gameStatus: String = "NOT_FINISH",
    @SerializedName("dialogState")
    val dialogState: Boolean = true,
    @SerializedName("playerOne")
    val playerOne: PlayerDto?,
    @SerializedName("playerTwo")
    val playerTwo: PlayerDto?,
    @SerializedName("boarder")
    var boarder: Map<String, String>?
)
