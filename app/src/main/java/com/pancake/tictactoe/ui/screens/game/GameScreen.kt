package com.pancake.tictactoe.ui.screens.game

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.pancake.tictactoe.R
import com.pancake.tictactoe.ui.screens.game.composables.GameBoard
import com.pancake.tictactoe.ui.screens.game.composables.GameScore
import com.pancake.tictactoe.ui.screens.game.composables.PlayButton
import com.pancake.tictactoe.ui.screens.game.composables.VerticalSpacer
import com.pancake.tictactoe.ui.theme.Brand
import com.pancake.tictactoe.ui.theme.backGround
import com.pancake.tictactoe.ui.theme.border1
import com.pancake.tictactoe.ui.theme.mainTypography
import com.pancake.tictactoe.ui.theme.radius2
import com.pancake.tictactoe.ui.theme.space16
import com.pancake.tictactoe.ui.theme.space24
import com.pancake.tictactoe.ui.theme.space8
import com.pancake.tictactoe.ui.theme.textPrimary

@Composable
fun GameScreen(
    viewModel: GameViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    GameContent(
        state = state,
        onClickGameBoard = viewModel::onClickGameBoard
    )
}

@Composable
private fun GameContent(
    state: GameUiState,
    onClickGameBoard: (Int) -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backGround)
            .padding(start = space16, end = space16, top = space16, bottom = space24),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar()
        Spacer(modifier = Modifier.weight(1f))
        if (state.isFinished) {
            VictoryStatus(isWin = true)
            Spacer(modifier = Modifier.weight(1f))
        }
        GameScore(state)
        GameBoard(state, onClick = onClickGameBoard)
        VerticalSpacer(height = space16)
        IdText(id = state.sessionId)
        Spacer(modifier = Modifier.weight(1f))
        if (state.isFinished) {
            PlayButton(onClick = {})
        }
    }
}

@Composable
fun TopBar() {
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
fun ScoreText(text: String) {
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
fun VictoryStatus(isWin: Boolean) {
    Text(
        text = if (isWin) stringResource(R.string.you_win) else stringResource(R.string.you_lose),
        style = mainTypography.headlineLarge,
        color = textPrimary
    )
    VerticalSpacer(height = space8)
    Text(
        text = if (isWin) stringResource(R.string.win_message) else stringResource(R.string.lose_message),
        style = mainTypography.labelSmall,
        color = textPrimary
    )
}

@Composable
fun IdText(id: String) {
    Text(
        text = "ID: $id",
        style = mainTypography.labelSmall,
        color = textPrimary
    )
}

