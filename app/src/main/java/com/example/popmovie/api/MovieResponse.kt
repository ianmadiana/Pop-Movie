package com.example.popmovie.api

import com.example.popmovie.data.model.Movie

data class MovieResponse(
    val results: List<Movie>
)