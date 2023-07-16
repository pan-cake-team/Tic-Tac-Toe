package com.pancake.tictactoe.domain.usecase

import android.util.Log
import com.google.gson.Gson
import com.pancake.tictactoe.data.remote.FirebaseFireStoreService
import com.pancake.tictactoe.data.remote.models.GameDto
import com.pancake.tictactoe.domain.mapper.toGame
import javax.inject.Inject

class UpdateGameUseCase @Inject constructor(
    private val firestore: FirebaseFireStoreService
) {
    suspend operator fun invoke(sessionId: String) {

        firestore.updateGame(sessionId).addOnSuccessListener { data ->
            var json = Gson()
            var result = json.fromJson<GameDto>(data.data.toString(), GameDto::class.java)
            Log.v("ameerzxy", "addOnSuccessListener ${result.toGame()}")
        }.addOnFailureListener { error ->
            Log.v("ameerzxy", "addOnFailureListener $error")
        }
    }
}