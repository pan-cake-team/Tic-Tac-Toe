package com.pancake.tictactoe.ui.screens.home

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pancake.tictactoe.ui.navigation.MainNavigationGraph


private const val ROUTE = MainNavigationGraph.HOME_SCREEN

fun NavController.navigateToHomeScreen() {
    navigate(ROUTE)
}

fun NavGraphBuilder.homeRoute(navController: NavController) {
    composable(ROUTE) {
        HomeScreen(navController)
    }
}