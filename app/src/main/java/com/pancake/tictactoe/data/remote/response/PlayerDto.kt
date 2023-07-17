package com.pancake.tictactoe.data.remote.response

import com.google.gson.annotations.SerializedName

data class PlayerDto(
    @SerializedName("id")
    var id: String?,
    @SerializedName("action")
    var action: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("isRoundPlayer")
    var isRoundPlayer: Boolean?,
    @SerializedName("score")
    val score: Int? = 0,
)