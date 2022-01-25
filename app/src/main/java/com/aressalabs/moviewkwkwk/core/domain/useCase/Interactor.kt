package com.aressalabs.moviewkwkwk.core.domain.useCase

import androidx.lifecycle.LiveData
import com.aressalabs.moviewkwkwk.core.domain.model.MovieModel
import com.aressalabs.moviewkwkwk.core.domain.model.MovieVideosModel
import com.aressalabs.moviewkwkwk.core.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow

class Interactor(private val repository: IRepository): UseCase {

    override fun loadPopularMovies() = repository.loadPopularMovies()

    override fun loadUpcomingMovies() = repository.loadUpcomingMovies()

    override fun loadNowPlayingMovies(): Flow<List<MovieModel>> {
        return repository.loadNowPlayingMovies()
    }

    override fun loadMovieVideo(id: Int): Flow<List<MovieVideosModel>> {
        return repository.loadMovieVideo(id)
    }

}