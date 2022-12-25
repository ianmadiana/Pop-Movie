package com.example.popmovie.ui.fav

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.popmovie.data.local.FavMovieRepository

class FavViewModel @ViewModelInject constructor(
    private val repository: FavMovieRepository
) : ViewModel(){
    val movies = repository.getFavMovies()
}