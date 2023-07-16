package com.pancake.tictactoe.data.remote

import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.DocumentSnapshot
import com.pancake.tictactoe.data.remote.models.GameDto
import com.pancake.tictactoe.data.remote.models.Session
import java.util.UUID


interface FirebaseFireStoreService {
    suspend fun createSession(playerName: String): String
    suspend fun joinSession(id: String, playerName: String): Boolean
    suspend fun updateGame(sessionId: String): Task<DocumentSnapshot>
    suspend fun getSession(id: String): Session?

    companion object {
        fun generateRandomId() = UUID.randomUUID().toString().split('-').last()
    }
}
