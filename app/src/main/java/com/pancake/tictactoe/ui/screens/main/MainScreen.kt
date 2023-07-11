package com.pancake.tictactoe.ui.screens.main

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.pancake.tictactoe.ui.navigation.MainNavigationGraph
import com.pancake.tictactoe.ui.theme.TicTacToeTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TicTacTocApp() {
    TicTacToeTheme {
        Scaffold {
            val navController = rememberNavController()
            MainNavigationGraph(navController)
        }
    }
}