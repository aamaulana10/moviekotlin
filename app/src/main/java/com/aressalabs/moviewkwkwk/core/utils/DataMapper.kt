package com.aressalabs.moviewkwkwk.core.utils

import com.aressalabs.moviewkwkwk.core.data.locale.entity.MovieEntity
import com.aressalabs.moviewkwkwk.core.data.remote.response.MovieResponse
import com.aressalabs.moviewkwkwk.core.domain.model.MovieModel

object DataMapper {

    fun mapResponsesToDomain(input: MovieResponse): List<MovieModel> {
        val movieList = ArrayList<MovieModel>()

        input.results.map {
            val movies = MovieModel(
                id = it.id,
                adult = it.adult,
                backdrop_path = it.backdrop_path,
                original_language = it.original_language,
                original_title = it.original_title,
                overview =  it.overview,
                popularity = it.popularity,
                poster_path =  it.poster_path,
                release_date = it.release_date,
                title =  it.title,
                video =  it.video,
                vote_average = it.vote_average,
                vote_count =  it.vote_count

            )
            movieList.add(movies)
        }

        return movieList
    }

    fun mapResponsesToEntities(input: List<MovieModel>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()

        input.map {
            val movies = MovieEntity(
                id = it.id,
                adult = it.adult,
                backdropPath = it.backdrop_path,
                originalLanguage = it.original_language,
                originalTitle = it.original_title,
                overview =  it.overview,
                popularity = it.popularity,
                posterPath =  it.poster_path,
                releaseDate = it.release_date,
                title =  it.title,
                video =  it.video,
                voteAverage = it.vote_average,
                voteCount =  it.vote_count

            )
            movieList.add(movies)
        }


        return movieList
    }

    fun mapEntitiesToDomain(input: List<MovieEntity>): List<MovieModel> =
        input.map {
            MovieModel(
                id = it.id,
                adult = it.adult,
                backdrop_path = it.backdropPath,
                original_language = it.originalLanguage,
                original_title = it.originalTitle,
                overview =  it.overview,
                popularity = it.popularity,
                poster_path =  it.posterPath,
                release_date = it.releaseDate,
                title =  it.title,
                video =  it.video,
                vote_average = it.voteAverage,
                vote_count =  it.voteCount
            )
        }

    fun mapDomainToEntity(input: MovieModel) = MovieEntity(
        id = input.id,
        adult = input.adult,
        backdropPath = input.backdrop_path,
        originalLanguage = input.original_language,
        originalTitle = input.original_title,
        overview =  input.overview,
        popularity = input.popularity,
        posterPath =  input.poster_path,
        releaseDate = input.release_date,
        title =  input.title,
        video =  input.video,
        voteAverage = input.vote_average,
        voteCount =  input.vote_count
    )
}