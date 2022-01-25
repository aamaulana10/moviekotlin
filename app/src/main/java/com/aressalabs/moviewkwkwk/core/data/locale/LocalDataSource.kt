package com.aressalabs.moviewkwkwk.core.data.locale

import com.aressalabs.moviewkwkwk.core.data.locale.entity.MovieEntity
import com.aressalabs.moviewkwkwk.core.data.locale.room.MovieDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource private constructor(private val movieDao: MovieDao) {

    companion object {
        private var instance: LocalDataSource? = null

        fun getInstance(movieDao: MovieDao): LocalDataSource =
            instance ?: synchronized(this) {
                instance ?: LocalDataSource(movieDao)
            }
    }

    fun loadPopularMovies(): Flow<List<MovieEntity>> = movieDao.loadPopularMovies()

    suspend fun insertPopularMovie(movieList: List<MovieEntity>) = movieDao.insertPopularMovie(movieList)


}