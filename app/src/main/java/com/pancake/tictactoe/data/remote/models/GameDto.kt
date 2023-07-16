package com.pancake.tictactoe.data.remote.models

import com.google.gson.annotations.SerializedName


data class GameDto(
    @SerializedName("sessionId")
    val sessionId: String?,
    @SerializedName("idOwnerGame")
    var idOwnerGame: String?,
    @SerializedName("counter")
    val counter: Int?,
    @SerializedName("gameStatus")
    val gameStatus: String?,
    @SerializedName("dialogState")
    val dialogState: Boolean?,
    @SerializedName("playerOne")
    val playerOne: PlayerDto?,
    @SerializedName("playerTwo")
    val playerTwo: PlayerDto?,
    @SerializedName("boarder")
    var boarder: Map<String, String>?
)
