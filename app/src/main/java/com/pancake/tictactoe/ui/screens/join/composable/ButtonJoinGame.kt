package com.pancake.tictactoe.ui.screens.join.composable

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.pancake.tictactoe.ui.theme.Brand
import com.pancake.tictactoe.ui.theme.border1
import com.pancake.tictactoe.ui.theme.buttonHeight
import com.pancake.tictactoe.ui.theme.mainTypography
import com.pancake.tictactoe.ui.theme.onPrimary
import com.pancake.tictactoe.ui.theme.radius4

@Composable
fun ButtonJoinGame(modifier: Modifier = Modifier, title: String, onClick: () -> Unit) {
    OutlinedButton(
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(contentColor = Brand, containerColor = onPrimary),
        border = BorderStroke(width = border1, color = Brand),
        shape = RoundedCornerShape(radius4),
        modifier = modifier
            .height(buttonHeight)
            ) {
        Text(
            text = title,
            style = mainTypography.titleLarge
        )
    }
}