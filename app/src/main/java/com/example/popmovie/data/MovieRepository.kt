package com.example.popmovie.data

import com.example.popmovie.api.MovieApi
import javax.inject.Inject
import javax.inject.Singleton
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.example.popmovie.data.MoviePageSource

@Singleton
class MovieRepository @Inject constructor (private val movieApi: MovieApi) {
    fun getNowPlaying() =
        Pager(
            config = PagingConfig(
                pageSize = 5,
                maxSize =20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {MoviePageSource(movieApi, null)}
        ).liveData

    fun getSearchMovies(query: String) =
        Pager(
            config = PagingConfig(
                pageSize = 5,
                maxSize = 20,
                enablePlaceholders = false
            ),
            pagingSourceFactory = {MoviePageSource(movieApi, query)}
        ).liveData
}