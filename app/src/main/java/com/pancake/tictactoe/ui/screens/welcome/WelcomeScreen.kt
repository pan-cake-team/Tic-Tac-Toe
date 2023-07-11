package com.pancake.tictactoe.ui.screens.welcome

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun WelcomeScreen(navController: NavController) {
    WelcomeContent()
}

@Composable
private fun WelcomeContent() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text("WelcomeScreen")
    }
}