package com.pancake.tictactoe.data.remote

import com.google.firebase.firestore.DocumentReference
import com.pancake.tictactoe.data.remote.response.GameDto
import java.util.UUID


interface FirebaseFireStoreService {
    suspend fun createSession(playerName: String): String
    suspend fun joinSession(id: String, playerName: String): Boolean
    suspend fun getGameDocumentReference(sessionId: String): DocumentReference
    suspend fun updateGame(game: GameDto)
//    suspend fun getSession(id: String): Session?

    companion object {
        fun generateRandomId() = UUID.randomUUID().toString().split('-').last()
    }
}
