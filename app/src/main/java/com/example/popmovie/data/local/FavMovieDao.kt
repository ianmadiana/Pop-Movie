package com.example.popmovie.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface FavMovieDao {
    @Insert
    suspend fun addToFavorite(favoriteMovie: FavMovie)

    @Query("SELECT * FROM fav_movie")
    fun getFavoriteMovie(): LiveData<List<FavMovie>>

    @Query("SELECT count(*) FROM fav_movie WHERE fav_movie.id_movie = :id")
    suspend fun checkMovie(id: String): Int

    @Query("DELETE FROM fav_movie WHERE fav_movie.id_movie = :id" )
    suspend fun removeFromFavorite(id: String) : Int
}