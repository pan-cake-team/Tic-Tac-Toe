package com.pancake.tictactoe.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.toObject
import com.pancake.tictactoe.data.remote.FirebaseFireStoreService.Companion.generateRandomId
import com.pancake.tictactoe.data.remote.models.Player
import com.pancake.tictactoe.data.remote.models.Session
import com.pancake.tictactoe.data.remote.exceptions.SessionCreationException
import com.pancake.tictactoe.data.remote.exceptions.SessionJoiningException
import com.pancake.tictactoe.data.remote.exceptions.SessionRetrievingException
import javax.inject.Inject
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine
import kotlin.jvm.Throws

class FirebaseFireStoreServiceImpl @Inject constructor(
    private val fireStore: FirebaseFirestore
) : FirebaseFireStoreService {
    private val collection by lazy { fireStore.collection(ROOT_COLLECTION_PATH) }

    @Throws(SessionCreationException::class)
    override suspend fun createSession(playerName: String): String {
        return suspendCoroutine { continuation ->
            val sessionId = generateRandomId()
            val sessionRef = collection.document(sessionId)
            val player = Player(name = playerName)
            val session = Session(
                id = sessionId,
                players = mutableListOf(player)
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

    @Throws(SessionRetrievingException::class)
    override suspend fun getSession(id: String): Session {
        return suspendCoroutine { continuation ->
            val sessionRef = collection.document(id)
            sessionRef.get().addOnSuccessListener { document ->
                runCatching { continuation.resume(document.toObject()!!) }
                    .onFailure { exception ->
                        val errorMessage = exception.message ?: SESSION_NOT_FOUND
                        continuation.resumeWithException(SessionRetrievingException(message = errorMessage))
                    }
            }
                .addOnFailureListener { exception ->
                    val errorMessage = exception.message ?: SESSION_RETRIEVING_FAILED
                    continuation.resumeWithException(SessionRetrievingException(message = errorMessage))
                }
        }
    }

    @Throws(SessionJoiningException::class)
    override suspend fun joinSession(id: String, playerName: String): Boolean {
        val session = getSession(id = id)
        val player = Player(name = playerName)
        return suspendCoroutine { continuation ->
            val sessionRef = collection.document(id)
            session.players.add(player)
            sessionRef.update(JOIN_PLAYER_PATH, session.players)
                .addOnSuccessListener {
                    continuation.resume(true)
                }
                .addOnFailureListener { exception ->
                    val errorMessage = exception.message ?: SESSION_JOINING_FAILED
                    continuation.resumeWithException(SessionJoiningException(message = errorMessage))
                }
        }
    }

    private companion object {
        const val ROOT_COLLECTION_PATH = "Session"
        const val JOIN_PLAYER_PATH = "player"
        const val SESSION_NOT_FOUND = "Session Not Found!"
        const val SESSION_JOINING_FAILED = "Session Joining failed!"
        const val SESSION_CREATION_FAILED = "Session creation failed!"
        const val SESSION_RETRIEVING_FAILED = "Session retrieving failed!"
    }
}