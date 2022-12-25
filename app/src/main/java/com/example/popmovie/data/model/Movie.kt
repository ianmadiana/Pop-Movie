package com.example.popmovie.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: String,
    val original_title: String,
    val overview: String?,
    val poster_path: String,
    val vote_average: String,
    val popularity: String
): Parcelable{
val baseUrl get() ="https://image.tmdb.org/t/p/w500"
}
