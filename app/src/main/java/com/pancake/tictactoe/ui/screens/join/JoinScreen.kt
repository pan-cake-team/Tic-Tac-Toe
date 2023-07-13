package com.pancake.tictactoe.ui.screens.join

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.pancake.tictactoe.R
import com.pancake.tictactoe.ui.screens.join.composable.FullColorButton
import com.pancake.tictactoe.ui.screens.join.composable.GameOutlineButton
import com.pancake.tictactoe.ui.theme.TextTertiary
import com.pancake.tictactoe.ui.theme.mainTypography
import com.pancake.tictactoe.ui.theme.onPrimary
import com.pancake.tictactoe.ui.theme.space16
import com.pancake.tictactoe.ui.theme.space24
import com.pancake.tictactoe.ui.theme.space72
import com.pancake.tictactoe.ui.theme.space8

//@Preview(backgroundColor = 0xFFEBEAEA)
@Composable
fun JoinScreen(
    navController: NavController,
    viewModel: JoinViewModel = hiltViewModel()
    ) {

    val state by viewModel.state.collectAsState()

    JoinContent(
        state = state,
        onCreateGameClicked = viewModel::showCreateGameDialog,
        onJoinGameClicked = viewModel::showJoinGameDialog,
        onCreateSession = {},
        onJoinToSession = {}
    )
}

@Composable
private fun JoinContent(
    state: JoinUiState,
    onCreateGameClicked: () -> Unit,
    onJoinGameClicked: () -> Unit,
    onCreateSession: () -> Unit,
    onJoinToSession: () -> Unit
) {
    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .background(color = onPrimary)
    ) {
        val (imageBigO, imageBlueX, imageBlackX, imageOrange, textGameName, textPlayWithFriend, buttonsColumn) = createRefs()
        val startGuideline = createGuidelineFromStart(space16)
        val endGuideline = createGuidelineFromEnd(space16)



        Column(
            modifier = Modifier
                .padding(horizontal = space16)
                .constrainAs(buttonsColumn) {
                    bottom.linkTo(imageBigO.top, space16)
                    start.linkTo(startGuideline)
                    end.linkTo(endGuideline)
                },
            verticalArrangement = Arrangement.spacedBy(space16)
        ) {
            FullColorButton(
                title = stringResource(R.string.create_game),
                onClick = { onCreateGameClicked() },
                modifier = Modifier.fillMaxWidth()
            )

            GameOutlineButton(
                title = stringResource(R.string.create_game),
                onClick = { onJoinGameClicked() },
                modifier = Modifier
                    .fillMaxWidth()
            )
        }



        Image(painter = painterResource(id = R.drawable.ic_black_x),
            contentDescription = null,
            modifier = Modifier.constrainAs(imageBlackX) {
                start.linkTo(parent.start)
                top.linkTo(parent.top, space72)
            })

        Image(painter = painterResource(id = R.drawable.ic_orange),
            contentDescription = null,
            modifier = Modifier.constrainAs(imageOrange) {
                end.linkTo(parent.end)
                top.linkTo(parent.top, space24)
            })

        Image(painter = painterResource(id = R.drawable.ic_big_o),
            contentDescription = null,
            modifier = Modifier.constrainAs(imageBigO) {
                start.linkTo(parent.start, space16)
                bottom.linkTo(imageBlueX.top)
            })

        Image(painter = painterResource(id = R.drawable.ic_blue_x),
            contentDescription = null,
            modifier = Modifier.constrainAs(imageBlueX) {
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
            })

        Text(text = stringResource(R.string.tic_tac_toe),
            style = mainTypography.headlineLarge,
            modifier = Modifier.constrainAs(textGameName) {
                top.linkTo(imageBlackX.bottom, space24)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
            })

        Text(text = stringResource(R.string.play_with_friend),
            style = mainTypography.headlineMedium,
            color = TextTertiary,
            modifier = Modifier.constrainAs(textPlayWithFriend) {
                top.linkTo(textGameName.bottom, space8)
                start.linkTo(textGameName.start)
                end.linkTo(textGameName.end)
            })


    }
}