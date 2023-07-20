package com.pancake.tictactoe.ui.screens.game

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pancake.tictactoe.R
import com.pancake.tictactoe.ui.screens.game.composables.GameBoard
import com.pancake.tictactoe.ui.screens.game.composables.PlayButton
import com.pancake.tictactoe.ui.screens.game.composables.PlayerInfo
import com.pancake.tictactoe.ui.screens.game.composables.ResultDialog
import com.pancake.tictactoe.ui.screens.game.composables.VerticalSpacer
import com.pancake.tictactoe.ui.screens.game.composables.gameStatusSubTitle
import com.pancake.tictactoe.ui.screens.game.composables.gameStatusTitle
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
    navController: NavController,
    viewModel: GameViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsState()
    val clipboardManager = LocalClipboardManager.current
    val context = LocalContext.current
    GameContent(
        state = state,
        playerId = viewModel.playerId!!,
        onClickGameBoard = viewModel::onClickGameBoard,
        onDismissDialog = viewModel::onClickDismissDialog,
        onClickPlayAgain = viewModel::onClickPlayAgain,
        onClickBack = { navController.popBackStack() },
        onClickCopyGameId = {
            clipboardManager.setText(AnnotatedString(state.sessionId))
            showToastMessage(context)
        }
    )
}

@Composable
private fun GameContent(
    state: GameUiState,
    playerId: String,
    onClickGameBoard: (Int) -> Unit,
    onDismissDialog: () -> Unit,
    onClickPlayAgain: () -> Unit,
    onClickCopyGameId: () -> Unit,
    onClickBack: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(backGround)
            .padding(start = space16, end = space16, top = space16, bottom = space24),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TopBar(onClick = onClickBack)
        Spacer(modifier = Modifier.weight(1f))
        if (state.isGameFinished()) {
            if (state.dialogState)
                ResultDialog(state, playerId, onDismiss = onDismissDialog)
            VictoryStatus(state, playerId)
            Spacer(modifier = Modifier.weight(1f))
        }
        PlayerInfo(state)
        GameBoard(state, onClick = onClickGameBoard)
        VerticalSpacer(height = space16)
        GameId(id = state.sessionId, onClick = onClickCopyGameId)
        Spacer(modifier = Modifier.weight(1f))
        if (state.isGameFinished()) {
            PlayButton(onClick = onClickPlayAgain)
        }
    }
}

@Composable
fun TopBar(onClick: () -> Unit) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Icon(
            modifier = Modifier.clickable(onClick = onClick),
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
fun VictoryStatus(state: GameUiState, playerId: String) {
    Text(
        text = gameStatusTitle(state, playerId),
        style = mainTypography.headlineLarge,
        color = textPrimary
    )
    VerticalSpacer(height = space8)
    Text(
        text = gameStatusSubTitle(state, playerId),
        style = mainTypography.labelSmall,
        color = textPrimary
    )
}

@Composable
fun GameId(id: String, onClick: () -> Unit) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(space8)
    ) {
        Text(
            text = "ID: $id",
            style = mainTypography.labelSmall,
            color = textPrimary
        )
        Image(
            modifier = Modifier.clickable(onClick = onClick),
            imageVector = ImageVector.vectorResource(R.drawable.ic_copy),
            contentDescription = stringResource(R.string.copy_icon),
        )
    }
}

fun showToastMessage(context: Context) {
    Toast.makeText(context, "gameId Copied", Toast.LENGTH_SHORT).show()
}

