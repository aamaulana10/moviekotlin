package com.aressalabs.moviewkwkwk.core.domain.useCase

import com.aressalabs.moviewkwkwk.core.domain.model.MovieModel
import kotlinx.coroutines.flow.Flow

interface UseCase {
    fun loadPopularMovies(): Flow<List<MovieModel>>
    fun loadUpcomingMovies(): Flow<List<MovieModel>>
    fun loadNowPlayingMovies(): Flow<List<MovieModel>>
}