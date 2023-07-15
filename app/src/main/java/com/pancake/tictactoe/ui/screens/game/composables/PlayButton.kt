package com.pancake.tictactoe.ui.screens.game.composables

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import com.pancake.tictactoe.R
import com.pancake.tictactoe.ui.theme.Brand
import com.pancake.tictactoe.ui.theme.border1
import com.pancake.tictactoe.ui.theme.mainTypography
import com.pancake.tictactoe.ui.theme.radius4
import com.pancake.tictactoe.ui.theme.space8

@Composable
fun PlayButton(onClick: () -> Unit) {
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .border(
                width = border1,
                color = Brand,
                shape = RoundedCornerShape(radius4)
            ),
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent)
    ) {
        Row(
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                painter = painterResource(id = R.drawable.ic_restart),
                contentDescription = "replay",
                tint = Brand
            )
            Spacer(modifier = Modifier.width(space8))
            Text(
                text = stringResource(R.string.play_again),
                style = mainTypography.titleLarge,
                color = Brand
            )
        }
    }
}