package com.pancake.tictactoe.ui.screens.game

import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.pancake.tictactoe.ui.navigation.MainNavigationGraph

private const val ROUTE = MainNavigationGraph.GAME_SCREEN

fun NavController.navigateToGameScreen(name: String, gameId: String) {
    navigate("$ROUTE/$name/$gameId")
}

fun NavGraphBuilder.gameScreen(navController: NavHostController) {
    composable(
        "$ROUTE/{${GameArgs.NAME}}/{${GameArgs.GAME_ID}}",
        arguments = listOf(
            navArgument(GameArgs.NAME) { NavType.StringType },
            navArgument(GameArgs.GAME_ID) { NavType.StringType }
        )
    ) { GameScreen(navController) }


}


class GameArgs(savedStateHandle: SavedStateHandle) {
    val name: String? = savedStateHandle[NAME]
    val gameId: String? = savedStateHandle[GAME_ID]

    companion object {
        const val NAME = "name"
        const val GAME_ID = "gameId"
    }
}
