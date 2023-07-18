package com.pancake.tictactoe.ui.screens.home.composable

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pancake.tictactoe.ui.navigation.MainNavigationGraph
import com.pancake.tictactoe.ui.screens.home.HomeScreen


private const val ROUTE = MainNavigationGraph.HOME_SCREEN

fun NavController.navigateToGameScreen() {
    navigate(ROUTE)
}

fun NavGraphBuilder.homeRoute(navController: NavController) {
    composable(ROUTE) {
        HomeScreen(navController)
    }
}