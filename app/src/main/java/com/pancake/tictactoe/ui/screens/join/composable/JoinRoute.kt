package com.pancake.tictactoe.ui.screens.join.composable

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pancake.tictactoe.ui.navigation.MainNavigationGraph
import com.pancake.tictactoe.ui.screens.join.JoinScreen


const val ROUTE = MainNavigationGraph.JOIN_SCREEN

fun NavController.navigateToGameScreen() {
    navigate("$ROUTE/")
}

fun NavGraphBuilder.joinRoute(navController: NavController) {
    composable(ROUTE) {
        JoinScreen(navController)
    }
}