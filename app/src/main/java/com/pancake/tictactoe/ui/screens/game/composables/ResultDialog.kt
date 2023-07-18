package com.pancake.tictactoe.ui.screens.game.composables

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.pancake.tictactoe.R
import com.pancake.tictactoe.ui.screens.game.GameStatus
import com.pancake.tictactoe.ui.screens.game.GameUiState
import com.pancake.tictactoe.ui.theme.backGround
import com.pancake.tictactoe.ui.theme.space16
import com.pancake.tictactoe.ui.theme.space24
import com.pancake.tictactoe.ui.theme.textSize16


@Composable
fun ResultDialog(state: GameUiState, playerId: String, onDismiss: () -> Unit) {
    Dialog(onDismissRequest = onDismiss) {
        Box(
            Modifier
                .width(200.dp)
                .background(backGround, RoundedCornerShape(space16))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(space16),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = getDialogTitle(state, playerId),
                    fontSize = textSize16,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily(Font(R.font.noto_serif)),
                    color = getDialogColor(state, playerId),
                    textAlign = TextAlign.Center
                )
                VerticalSpacer(height = space24)
                Image(
                    modifier = Modifier.size(150.dp),
                    painter = painterResource(getDialogImage(state, playerId)),
                    contentDescription = ""
                )
                VerticalSpacer(height = space16)
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(space24),
                    colors = ButtonDefaults.buttonColors(getDialogColor(state, playerId)),
                    onClick = onDismiss,
                ) {
                    Text(
                        text = stringResource(R.string.ok), fontSize = textSize16,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily(Font(R.font.noto_serif)),
                        color = Color.White,
                    )
                }
            }
        }
    }
}

fun getDialogTitle(state: GameUiState, playerId: String): String {
    return when (state.gameStatus) {
        GameStatus.PLAYER_ONE_WIN -> if (state.playerOne.id == playerId) "Congrats ${state.playerOne.name} Win" else "Sorry you lose"
        GameStatus.PLAYER_TWO_WIN -> if (state.playerTwo.id == playerId) "Congrats ${state.playerTwo.name} Win" else "Sorry you lose"
        GameStatus.DRAW -> "Victory Draw"
        else -> ""
    }
}

fun getDialogColor(state: GameUiState, playerId: String): Color {
    return when (state.gameStatus) {
        GameStatus.PLAYER_ONE_WIN -> if (state.playerOne.id == playerId) Color(0xFFFFE437) else Color(
            0xFFFF3434
        )

        GameStatus.PLAYER_TWO_WIN -> if (state.playerTwo.id == playerId) Color(0xFFFFE437) else Color(
            0xFFFF3434
        )

        GameStatus.DRAW -> Color(0xFF000000)
        else -> Color.White
    }
}

fun getDialogImage(state: GameUiState, playerId: String): Int {
    return when (state.gameStatus) {
        GameStatus.PLAYER_ONE_WIN -> if (state.playerOne.id == playerId) R.drawable.image_winer else R.drawable.image_lose


        GameStatus.PLAYER_TWO_WIN -> if (state.playerTwo.id == playerId) R.drawable.image_winer else R.drawable.image_lose

        GameStatus.DRAW -> R.drawable.image_draw
        else -> R.drawable.image_draw
    }
}