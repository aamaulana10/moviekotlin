package com.aressalabs.moviewkwkwk.core.domain.useCase

import com.aressalabs.moviewkwkwk.core.data.Resource
import com.aressalabs.moviewkwkwk.core.domain.model.MovieModel
import com.aressalabs.moviewkwkwk.core.domain.model.MovieVideosModel
import kotlinx.coroutines.flow.Flow

interface UseCase {
    fun loadPopularMovies(): Flow<Resource<List<MovieModel>>>
    fun loadUpcomingMovies(): Flow<List<MovieModel>>
    fun loadNowPlayingMovies(): Flow<List<MovieModel>>
    fun loadMovieVideo(id: Int): Flow<List<MovieVideosModel>>
}