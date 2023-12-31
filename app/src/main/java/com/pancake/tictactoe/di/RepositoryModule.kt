package com.pancake.tictactoe.di

import com.pancake.tictactoe.data.remote.FirebaseFireStoreService
import com.pancake.tictactoe.data.remote.FirebaseFireStoreServiceImpl
import com.pancake.tictactoe.data.repository.TicTacToeRepository
import com.pancake.tictactoe.data.repository.TicTacToeRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindTicTacToeRepository(repository: TicTacToeRepositoryImpl): TicTacToeRepository

    @Binds
    abstract fun bindFirebaseFireStoreService(service: FirebaseFireStoreServiceImpl): FirebaseFireStoreService
}