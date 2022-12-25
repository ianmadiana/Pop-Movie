package com.example.popmovie.api

import com.example.popmovie.BuildConfig
import retrofit2.http.GET
import retrofit2.http.Query

interface MovieApi {

    companion object{
        const val BASE_URL = "https://api.themoviedb.org/3/"
        const val API_KEY = BuildConfig.POPMOVIE_API_KEY
    }

    @GET("movie/now_playing?api_key=$API_KEY")
    suspend fun getNowPlaying(
        @Query("page") position: Int
    ): MovieResponse

    @GET("search/movie?api_key=$API_KEY")
    suspend fun searchMovies(
        @Query("query") query: String,
        @Query("page") page: Int
    ): MovieResponse
}