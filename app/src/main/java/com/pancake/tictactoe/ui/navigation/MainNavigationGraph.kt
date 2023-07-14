package com.pancake.tictactoe.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.pancake.tictactoe.ui.screens.game.GameScreen

@Composable
fun MainNavigationGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = MainNavigationGraph.GAME_SCREEN
    ) {
        composable(MainNavigationGraph.GAME_SCREEN) { GameScreen() }
    }
}

object MainNavigationGraph {
    const val WELCOME_SCREEN = "welcomeScreen"
    const val GAME_SCREEN = "gameScreen"
}