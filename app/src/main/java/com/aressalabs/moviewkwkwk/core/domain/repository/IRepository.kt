package com.aressalabs.moviewkwkwk.core.domain.repository

import com.aressalabs.moviewkwkwk.core.domain.model.MovieModel
import kotlinx.coroutines.flow.Flow

interface IRepository {

    fun loadPopularMovies(): Flow<List<MovieModel>>
    fun loadUpcomingMovies(): Flow<List<MovieModel>>
    fun loadNowPlayingMovies(): Flow<List<MovieModel>>

}