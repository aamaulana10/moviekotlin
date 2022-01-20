package com.aressalabs.moviewkwkwk.core.domain.useCase

import androidx.lifecycle.LiveData
import com.aressalabs.moviewkwkwk.core.domain.model.MovieModel
import com.aressalabs.moviewkwkwk.core.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow

class Interactor(private val repository: IRepository): UseCase {

    override fun loadPopularMovies(): Flow<List<MovieModel>> {
        return repository.loadPopularMovies()
    }

    override fun loadUpcomingMovies(): Flow<List<MovieModel>> {
        return repository.loadUpcomingMovies()
    }

    override fun loadNowPlayingMovies(): Flow<List<MovieModel>> {
        return repository.loadNowPlayingMovies()
    }

}