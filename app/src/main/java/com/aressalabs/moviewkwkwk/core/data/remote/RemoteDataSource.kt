package com.aressalabs.moviewkwkwk.core.data.remote

import android.util.Log
import com.aressalabs.moviewkwkwk.core.data.remote.network.ApiResponse
import com.aressalabs.moviewkwkwk.core.data.remote.network.ApiService
import com.aressalabs.moviewkwkwk.core.domain.model.MovieModel
import com.aressalabs.moviewkwkwk.core.domain.model.MovieVideosModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.lang.Exception

class RemoteDataSource private constructor(private val apiService: ApiService) {

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(service: ApiService): RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource(service)
            }
    }


     fun loadPopularMovies(): Flow<ApiResponse<List<MovieModel>>> {

        return flow {

            try {

                val response = apiService.getPopularMovies()
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(ApiResponse.Success(response.results))
                } else {
                    emit(ApiResponse.Empty)
                }
            } catch (e: Exception) {
                Log.e("RemoteDataSource", e.toString())
                emit(ApiResponse.Error(e.toString()))
            }

        }.flowOn(Dispatchers.IO)
    }

     fun loadUpcomingMovies(): Flow<List<MovieModel>> {

        return flow {

            try {

                val response = apiService.getUpcomingMovies()
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(dataArray)
                } else {
                    emit(emptyList())
                }
            } catch (e: Exception) {
                Log.e("RemoteDataSource", e.toString())
                throw e
            }

        }.flowOn(Dispatchers.IO)
    }

     fun loadNowPlayingMovies(): Flow<List<MovieModel>> {

        return flow {

            try {

                val response = apiService.getNowPlayingMovies()
                val dataArray = response.results
                if (dataArray.isNotEmpty()) {
                    emit(dataArray)
                } else {
                    emit(emptyList())
                }
            } catch (e: Exception) {
                Log.e("RemoteDataSource", e.toString())
                throw e
            }

        }.flowOn(Dispatchers.IO)
    }

    fun loadMovieVideo(id: Int): Flow<List<MovieVideosModel>> {

        return flow {

            try {

                val response = apiService.loadMovieVideo(id)
                val dataArray = response.results

                Log.d("Response videos", dataArray.toString())

                if (dataArray.isNotEmpty()) {
                    emit(dataArray)
                } else {
                    emit(emptyList())
                }
            } catch (e: Exception) {
                Log.e("RemoteDataSource", e.toString())
                throw e
            }

        }.flowOn(Dispatchers.IO)
    }
}