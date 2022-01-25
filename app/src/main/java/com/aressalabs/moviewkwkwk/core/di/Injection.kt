package com.aressalabs.moviewkwkwk.core.di

import android.content.Context
import com.aressalabs.moviewkwkwk.core.data.Repository
import com.aressalabs.moviewkwkwk.core.data.locale.LocalDataSource
import com.aressalabs.moviewkwkwk.core.data.locale.room.MovieDatabase
import com.aressalabs.moviewkwkwk.core.data.remote.RemoteDataSource
import com.aressalabs.moviewkwkwk.core.data.remote.network.ApiConfig
import com.aressalabs.moviewkwkwk.core.domain.repository.IRepository
import com.aressalabs.moviewkwkwk.core.domain.useCase.Interactor
import com.aressalabs.moviewkwkwk.core.domain.useCase.UseCase

object Injection {

    private fun provideRepository(context: Context): IRepository {

        val database = MovieDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())
        val localDataSource = LocalDataSource.getInstance(database.movieDao())

        return Repository.getInstance(remoteDataSource, localDataSource)
    }

    fun provideUseCase(context: Context): UseCase {
        val repository = provideRepository(context)
        return Interactor(repository)
    }
}