package com.pancake.tictactoe.domain.usecase

import com.google.gson.Gson
import com.pancake.tictactoe.data.remote.FirebaseFireStoreService
import com.pancake.tictactoe.data.remote.response.GameDto
import com.pancake.tictactoe.domain.mapper.toGame
import com.pancake.tictactoe.domain.model.Game
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject

class UpdateGameUseCase @Inject constructor(
    private val firestore: FirebaseFireStoreService,
    private val gson: Gson,
) {
    suspend operator fun invoke(sessionId: String): Flow<Game> = callbackFlow {
        val lis =
            firestore.getGameDocumentReference(sessionId).addSnapshotListener { snapshot, error ->

                if (snapshot != null && snapshot.exists()) {
                    try {
                        trySend(convertStringToGameDto(snapshot.data.toString()).toGame())
                    } catch (ex: Exception) {
                        throw IllegalArgumentException(ex)
                    }
                } else {
                    Throwable("Document does not exist.")

                }

            }

        awaitClose { lis.remove() }
    }


    private fun convertStringToGameDto(data: String): GameDto {
        return gson.fromJson(data, GameDto::class.java)
    }
}