package com.pancake.tictactoe.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.pancake.tictactoe.ui.screens.game.gameScreen
import com.pancake.tictactoe.ui.screens.join.composable.joinRoute
import com.pancake.tictactoe.ui.screens.welcome.welcomeRoute


@Composable
fun MainNavigationGraph(navController: NavHostController) {

    NavHost(
        navController = navController,
        startDestination = MainNavigationGraph.JOIN_SCREEN
    ) {
        welcomeRoute(navController)
        joinRoute(navController)
        gameScreen(navController)

    }
}

object MainNavigationGraph {
    const val WELCOME_SCREEN = "welcomeScreen"
    const val JOIN_SCREEN = "joinScreen"
    const val GAME_SCREEN = "gameScreen"
}