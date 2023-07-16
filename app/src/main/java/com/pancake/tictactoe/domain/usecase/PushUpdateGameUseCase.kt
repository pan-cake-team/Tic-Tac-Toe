package com.pancake.tictactoe.domain.usecase

import com.pancake.tictactoe.data.remote.FirebaseFireStoreService
import com.pancake.tictactoe.domain.mapper.toGameDto
import com.pancake.tictactoe.domain.model.Game
import javax.inject.Inject

class PushUpdateGameUseCase @Inject constructor(
    private val firestore: FirebaseFireStoreService,
) {
    suspend operator fun invoke(game: Game) {
        firestore.updateGame(game.toGameDto())

    }


}