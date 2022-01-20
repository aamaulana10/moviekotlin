package com.aressalabs.moviewkwkwk.core.di

import android.content.Context
import com.aressalabs.moviewkwkwk.core.data.Repository
import com.aressalabs.moviewkwkwk.core.data.remote.RemoteDataSource
import com.aressalabs.moviewkwkwk.core.data.remote.network.ApiConfig
import com.aressalabs.moviewkwkwk.core.domain.repository.IRepository
import com.aressalabs.moviewkwkwk.core.domain.useCase.Interactor
import com.aressalabs.moviewkwkwk.core.domain.useCase.UseCase

object Injection {
    private fun provideRepository(context: Context): IRepository {

        val remoteDataSource = RemoteDataSource.getInstance(ApiConfig.provideApiService())

        return Repository.getInstance(remoteDataSource)
    }

    fun provideUseCase(context: Context): UseCase {
        val repository = provideRepository(context)
        return Interactor(repository)
    }
}