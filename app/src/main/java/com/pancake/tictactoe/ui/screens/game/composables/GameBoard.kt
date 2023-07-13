package com.pancake.tictactoe.ui.screens.game.composables

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.pancake.tictactoe.ui.theme.Gray


@OptIn(ExperimentalFoundationApi::class)
@Composable
@Preview(showBackground = true)
fun GameBoard(){
    LazyVerticalGrid(
        cells = GridCells.Fixed(3)
    ){
        items(count = 9){
            GameBoardItem()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun GameBoardItem(){
    var state by remember {
        mutableStateOf(1)
    }
    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = Gray,
            )
            .padding(26.dp)
            .clickable { state = 1 }
    ) {
        when(state){
            0 -> Spacer(modifier = Modifier.size(56.dp))
            1 -> Circle(modifier = Modifier.align(Alignment.Center))
            2 -> Cross(modifier = Modifier.align(Alignment.Center))
        }
    }
}