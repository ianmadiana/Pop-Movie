package com.example.popmovie.ui.movie

import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.popmovie.data.MovieRepository

import javax.inject.Inject


class MovieViewModel @ViewModelInject constructor (
    private val repository: MovieRepository,
    @Assisted state: SavedStateHandle
) : ViewModel() {
    companion object{
        private const val CURRENT_QUERY = "current_query"
        private const val EMPTY_QUERY = ""
    }

    private val currentQuery = state.getLiveData(CURRENT_QUERY, EMPTY_QUERY)
    val movies = currentQuery.switchMap { query ->
        if (!query.isEmpty()){
            repository.getSearchMovies(query)
        }else{
            repository.getNowPlaying().cachedIn(viewModelScope)
        }
    }

    fun searchMovies(query: String){
        currentQuery.value = query
    }
}