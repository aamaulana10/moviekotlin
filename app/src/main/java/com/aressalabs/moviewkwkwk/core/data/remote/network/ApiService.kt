package com.aressalabs.moviewkwkwk.core.data.remote.network

import com.aressalabs.moviewkwkwk.core.data.remote.response.MovieResponse
import com.aressalabs.moviewkwkwk.core.domain.model.MovieVideosResponse
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("3/movie/popular?api_key=5497119fe607a02621a85d7e0e376fcd&language=en-US")
    suspend fun getPopularMovies(): MovieResponse

    @GET("3/movie/upcoming?api_key=5497119fe607a02621a85d7e0e376fcd&language=en-US")
    suspend fun getUpcomingMovies(): MovieResponse

    @GET("3/movie/now_playing?api_key=5497119fe607a02621a85d7e0e376fcd&language=en-US")
    suspend fun getNowPlayingMovies(): MovieResponse

    @GET("3/movie/{movie_id}/videos?api_key=5497119fe607a02621a85d7e0e376fcd&language=en-US")
    suspend fun loadMovieVideo(@Path("movie_id") id: Int,): MovieVideosResponse
}