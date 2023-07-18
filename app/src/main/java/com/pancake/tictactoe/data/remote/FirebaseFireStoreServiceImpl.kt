package com.pancake.tictactoe.data.remote

import com.google.firebase.firestore.DocumentReference
import com.google.firebase.firestore.FirebaseFirestore
import com.pancake.tictactoe.data.localStorage.SharedPrefManager
import com.pancake.tictactoe.data.remote.FirebaseFireStoreService.Companion.generateRandomId
import com.pancake.tictactoe.data.remote.exceptions.SessionCreationException
import com.pancake.tictactoe.data.remote.exceptions.SessionJoiningException
import com.pancake.tictactoe.data.remote.response.GameDto
import com.pancake.tictactoe.data.remote.response.PlayerDto
import com.pancake.tictactoe.data.remote.utill.toMap
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class FirebaseFireStoreServiceImpl @Inject constructor(
    private val fireStore: FirebaseFirestore
) : FirebaseFireStoreService {
    private val collection by lazy { fireStore.collection(ROOT_COLLECTION_PATH) }

    @Throws(SessionCreationException::class)
    override suspend fun createSession(playerName: String): String {
        val randomId = generateRandomId()
        SharedPrefManager.playerId = randomId
        return suspendCoroutine { continuation ->
            val sessionId = generateRandomId()
            val sessionRef = collection.document(sessionId)

            val session = setDefaultGameValue(
                sessionId = sessionId,
                idPlayerOne = randomId,
                namePlayer = playerName
            )
            sessionRef
                .set(session)
                .addOnSuccessListener {
                    continuation.resume(sessionId)
                }
                .addOnFailureListener { exception ->
                    val errorMessage = exception.message ?: SESSION_CREATION_FAILED
                    continuation.resumeWithException(SessionCreationException(message = errorMessage))
                }
        }
    }

    private fun setDefaultGameValue(
        sessionId: String,
        idPlayerOne: String,
        namePlayer: String,
    ): GameDto {
        return GameDto(
            sessionId = sessionId,
            idOwnerGame = idPlayerOne,
            playerOne = PlayerDto(
                id = idPlayerOne,
                name = namePlayer,
                roundPlayer = true,
                action = CROSS
            ),
            playerTwo = null,
            boarder = (0..8).associate { it.toString() to EMPTY }
        )
    }

    @Throws(SessionJoiningException::class)
    override suspend fun joinSession(sessionId: String, playerName: String): Boolean {
        val randomId = generateRandomId()
        SharedPrefManager.playerId = randomId

        val player = PlayerDto(
            id = randomId,
            name = playerName,
            action = CIRCLE,
            roundPlayer = false,
        ).toMap()


        return suspendCoroutine { continuation ->
            val sessionRef = collection.document(sessionId)
            sessionRef.update(PLAYER_TOW, player)
                .addOnSuccessListener {
                    continuation.resume(true)
                }
                .addOnFailureListener { exception ->
                    val errorMessage = exception.message ?: SESSION_JOINING_FAILED
                    continuation.resumeWithException(SessionJoiningException(message = errorMessage))
                }
        }
    }

    override suspend fun getGameDocumentReference(sessionId: String): DocumentReference {
        return collection.document(sessionId)
    }

    override suspend fun updateGame(game: GameDto) {
        collection.document(game.sessionId!!).update(game.toMap())
    }


    private companion object {
        const val ROOT_COLLECTION_PATH = "Session"
        const val JOIN_PLAYER_PATH = "players"
        const val SESSION_NOT_FOUND = "Session Not Found!"
        const val SESSION_JOINING_FAILED = "Session Joining failed!"
        const val SESSION_CREATION_FAILED = "Session creation failed!"
        const val SESSION_RETRIEVING_FAILED = "Session retrieving failed!"
        const val PLAYER_TOW = "playerTwo"
        const val CIRCLE = "CIRCLE"
        const val CROSS = "CROSS"
        const val EMPTY = "EMPTY"
    }
}