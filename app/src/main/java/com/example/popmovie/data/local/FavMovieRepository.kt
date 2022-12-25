package com.example.popmovie.data.local

import javax.inject.Inject

class FavMovieRepository @Inject constructor(
    private val favoriteMovieDao: FavMovieDao
){
    suspend fun addToFavorite(favoriteMovie: FavMovie) = favoriteMovieDao.addToFavorite(favoriteMovie)
    fun getFavMovies() = favoriteMovieDao.getFavoriteMovie()
    suspend fun checkMovie(id: String) = favoriteMovieDao.checkMovie(id)
    suspend fun removeFromFavorite(id: String) {
        favoriteMovieDao.removeFromFavorite(id)
    }
}