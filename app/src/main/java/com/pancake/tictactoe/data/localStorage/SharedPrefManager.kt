package com.pancake.tictactoe.data.localStorage

import android.content.Context
import android.content.SharedPreferences

object SharedPrefManager {

    private var sharedPreference: SharedPreferences? = null

    private const val SHARED_PREFERENCE_Name = "sharedPreference"
    private const val PLAYER_NAME = "playerName"

    fun getInit(context: Context): SharedPreferences {
        sharedPreference =
            context.getSharedPreferences(SHARED_PREFERENCE_Name, Context.MODE_PRIVATE)
        return sharedPreference!!
    }

    var playerName: String?
        get() = sharedPreference?.getString(PLAYER_NAME, "")
        set(value) {
            sharedPreference?.edit()?.putString(PLAYER_NAME, value)?.apply()
        }

}