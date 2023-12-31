@file:Suppress("OPT_IN_IS_NOT_ENABLED")

package com.pancake.tictactoe.ui.screens.home.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.pancake.tictactoe.R
import com.pancake.tictactoe.ui.screens.game.composables.SpacerVertical16
import com.pancake.tictactoe.ui.screens.game.composables.SpacerVertical24
import com.pancake.tictactoe.ui.screens.home.HomeUiState


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateGameDialog(
    state:HomeUiState,
    onDismiss: () -> Unit,
    onChangeName: (String) -> Unit,
    onClickDone: () -> Unit,
) {

    Dialog(onDismissRequest = onDismiss) {
        Surface(
            shape = RoundedCornerShape(16.dp),
            color = Color.White
        ) {
            Box(
                contentAlignment = Alignment.Center
            ) {
                Column(modifier = Modifier.padding(20.dp)) {
                    Text(
                        text = stringResource(id = R.string.enter_your_name),
                        style = MaterialTheme.typography.headlineMedium
                    )

                    SpacerVertical16()

                    TextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                BorderStroke(
                                    color = Color.Gray,
                                    width = 2.dp,
                                ),
                                shape = RoundedCornerShape(4)
                            ),
                        colors = TextFieldDefaults.textFieldColors(
                            containerColor = Color.Transparent,
                            focusedIndicatorColor = Color.Transparent,
                            unfocusedIndicatorColor = Color.Transparent
                        ),

                        placeholder = { Text(text = stringResource(id = R.string.name)) },
                        value = state.playerName,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                        onValueChange = {
                            onChangeName(it)
                            validate(it)
                        },
                        singleLine = true,
                        isError = state.isNameEmpty,
                        trailingIcon = {
                            if (state.isNameEmpty)
                                Icon(
                                    ImageVector.vectorResource(R.drawable.ic_error),
                                    "error",
                                    tint = MaterialTheme.colorScheme.error
                                )
                        },
                        keyboardActions = KeyboardActions { validate(state.playerName) }

                    )

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(
                        text = stringResource(id = R.string.enter_game_id),
                        style = MaterialTheme.typography.headlineMedium
                    )

                    SpacerVertical24()
                    Button(
                        onClick = onClickDone,
                        shape = RoundedCornerShape(4.dp),
                        modifier = Modifier
                            .height(40.dp)
                    ) {
                        Text(text = stringResource(id = R.string.create_game))
                    }
                }
            }
        }
    }
}
