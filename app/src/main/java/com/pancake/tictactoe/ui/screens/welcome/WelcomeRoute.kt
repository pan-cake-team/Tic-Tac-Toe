package com.pancake.tictactoe.ui.screens.welcome

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.pancake.tictactoe.ui.navigation.MainNavigationGraph


const val ROUTE = MainNavigationGraph.WELCOME_SCREEN

fun NavController.navigateToOnBoarding() {
    navigate(ROUTE)
}

fun NavGraphBuilder.welcomeRoute(navController: NavController) {
    composable(ROUTE) {
        WelcomeScreen(navController)
    }
}