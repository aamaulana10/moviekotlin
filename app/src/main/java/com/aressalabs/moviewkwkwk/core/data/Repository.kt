package com.aressalabs.moviewkwkwk.core.data

import com.aressalabs.moviewkwkwk.core.data.remote.RemoteDataSource
import com.aressalabs.moviewkwkwk.core.domain.model.MovieModel
import com.aressalabs.moviewkwkwk.core.domain.repository.IRepository
import kotlinx.coroutines.flow.Flow

class Repository(private val remoteDataSource: RemoteDataSource) : IRepository {

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(
            remoteData: RemoteDataSource
        ): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remoteData)
            }
    }

     override fun loadPopularMovies(): Flow<List<MovieModel>> {

        return remoteDataSource.loadPopularMovies()
    }

    override fun loadUpcomingMovies(): Flow<List<MovieModel>> {
       return remoteDataSource.loadUpcomingMovies()
    }

    override fun loadNowPlayingMovies(): Flow<List<MovieModel>> {
        return remoteDataSource.loadNowPlayingMovies()
    }

}