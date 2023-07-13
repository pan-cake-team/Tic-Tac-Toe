package com.pancake.tictactoe.ui.screens.game

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.pancake.tictactoe.R
import com.pancake.tictactoe.ui.screens.game.composables.GameBoard
import com.pancake.tictactoe.ui.screens.game.composables.PlayButton
import com.pancake.tictactoe.ui.theme.Brand
import com.pancake.tictactoe.ui.theme.backGround
import com.pancake.tictactoe.ui.theme.border1
import com.pancake.tictactoe.ui.theme.mainTypography
import com.pancake.tictactoe.ui.theme.radius2
import com.pancake.tictactoe.ui.theme.space16
import com.pancake.tictactoe.ui.theme.space24
import com.pancake.tictactoe.ui.theme.space64
import com.pancake.tictactoe.ui.theme.space8
import com.pancake.tictactoe.ui.theme.textPrimary

@Composable
fun GameScreen(
    viewModel: GameViewModel = hiltViewModel()
){
    val state = viewModel.state.collectAsState()
    GameContent(state.value)
}

@Composable
private fun GameContent(state: GameUiState) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backGround)
            .padding(start = space16, end = space16, top = space16, bottom = space24),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        topBar()
        Spacer(modifier = Modifier.height(40.dp))
        if (state.isFinished){
            victoryStatus(isWin = true)
            Spacer(modifier = Modifier.height(space64))
        }else{
            Spacer(modifier = Modifier.height(164.dp))
        }
        GameScore()
        GameBoard()
        Spacer(modifier = Modifier.height(space16))
        IdText(id = "123456")
        Spacer(modifier = Modifier.height(64.dp))
        if (state.isFinished){
            PlayButton()
        }
    }
}

@Composable
fun topBar(){
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            imageVector = Icons.Default.ArrowBack,
            contentDescription = "back",
            tint = Brand
        )
    }
}


@Composable
@Preview(showBackground = true)
fun GameScore(player1: String = "Hassan", player2: String = "Hassan", score: String= "0 - 0"){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = space16, end = space16, bottom = space16),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {

        playerName(name = player1)
        scoreText(text = score)
        playerName(name = player2)
    }
}

@Composable
fun playerName(name: String){
    Text(
        text = name,
        style = mainTypography.titleLarge,
        color = textPrimary
    )
}

@Composable
fun scoreText(text: String){
    Text(
        modifier = Modifier
            .border(
                width = border1,
                color = Brand,
                shape = RoundedCornerShape(radius2)
            )
            .padding(horizontal = space24, vertical = space8),
        text = text,
        style = mainTypography.titleLarge,
        color = Brand
    )
}

@Composable
fun victoryStatus(isWin: Boolean){
    Text(
        text = if (isWin) stringResource(R.string.you_win) else stringResource(R.string.you_lose),
        style = mainTypography.headlineLarge,
        color = textPrimary
    )

    Text(
        text = if (isWin) stringResource(R.string.win_message) else stringResource(R.string.lose_message),
        style = mainTypography.labelSmall,
        color = textPrimary
    )
}

@Composable
fun IdText(id: String){
    Text(
        text = "ID: $id",
        style = mainTypography.labelSmall,
        color = textPrimary
    )
}

