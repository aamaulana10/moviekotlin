package com.aressalabs.moviewkwkwk.core.data

import com.aressalabs.moviewkwkwk.core.data.locale.LocalDataSource
import com.aressalabs.moviewkwkwk.core.data.remote.RemoteDataSource
import com.aressalabs.moviewkwkwk.core.data.remote.network.ApiResponse
import com.aressalabs.moviewkwkwk.core.data.remote.response.MovieResponse
import com.aressalabs.moviewkwkwk.core.domain.model.MovieModel
import com.aressalabs.moviewkwkwk.core.domain.model.MovieVideosModel
import com.aressalabs.moviewkwkwk.core.domain.repository.IRepository
import com.aressalabs.moviewkwkwk.core.utils.DataMapper
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.map

class Repository private constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
)
    : IRepository {

    companion object {
        @Volatile
        private var instance: Repository? = null

        fun getInstance(
            remoteData: RemoteDataSource,
            localData: LocalDataSource,
        ): Repository =
            instance ?: synchronized(this) {
                instance ?: Repository(remoteData, localData)
            }
    }

    override fun loadPopularMovies(): Flow<Resource<List<MovieModel>>> =
        object : NetworkBoundResource<List<MovieModel>, List<MovieModel>>() {
            override fun loadFromDB(): Flow<List<MovieModel>> {

                return localDataSource.loadPopularMovies().map {
                    DataMapper.mapEntitiesToDomain(it)
                }
            }

            override fun shouldFetch(data: List<MovieModel>?): Boolean {

                return true
            }

            override suspend fun createCall(): Flow<ApiResponse<List<MovieModel>>> {

                return remoteDataSource.loadPopularMovies()
            }

            override suspend fun saveCallResult(data: List<MovieModel>) {

                val dataMovies = DataMapper.mapResponsesToEntities(data)

                return localDataSource.insertPopularMovie(dataMovies)
            }


        }.asFlow()


    override fun loadUpcomingMovies(): Flow<List<MovieModel>> {
       return remoteDataSource.loadUpcomingMovies()
    }

    override fun loadNowPlayingMovies(): Flow<List<MovieModel>> {
        return remoteDataSource.loadNowPlayingMovies()
    }

    override fun loadMovieVideo(id: Int): Flow<List<MovieVideosModel>> {
        return remoteDataSource.loadMovieVideo(id)
    }

}