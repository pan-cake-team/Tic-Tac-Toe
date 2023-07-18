package com.pancake.tictactoe.ui.screens.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.LaunchedEffect
import com.pancake.tictactoe.data.localStorage.SharedPrefManager
import com.pancake.tictactoe.data.remote.FirebaseFireStoreService
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var firebaseFireStoreService: FirebaseFireStoreService


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        SharedPrefManager.getInit(applicationContext)
        setContent {
            TicTacTocApp()

            LaunchedEffect(Unit) {
                with(firebaseFireStoreService) {
//                    val sessionId = createSession("Ameer")
//                    getGameDocumentReference("165dccc522ae")
//                    joinSession(sessionId, "mostafa")
                }
            }
        }
    }
}

