package com.pancake.tictactoe.data.remote.response

import com.google.gson.annotations.SerializedName

data class PlayerDto(
    @SerializedName("id")
    val id: String?,
    @SerializedName("action")
    val action: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("roundPlayer")
    val roundPlayer: Boolean?,
    @SerializedName("score")
    val score: Int? = 0,
)