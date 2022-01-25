package com.aressalabs.moviewkwkwk.core.data.locale.room

import androidx.room.*
import com.aressalabs.moviewkwkwk.core.data.locale.entity.MovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movieEntity")
    fun loadPopularMovies(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPopularMovie(movie: List<MovieEntity>)

}