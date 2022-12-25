package com.example.popmovie.data.local

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Entity(tableName = "fav_movie")
@Parcelize
data class FavMovie(
    var id_movie: String,
    val original_title: String,
    val overview: String?,
    val poster_path: String,
    val vote_average: String,
    val popularity: String
) : Serializable, Parcelable{
    @PrimaryKey (autoGenerate = true)
    val id: Int = 0
    val baseUrl get() = "https://image.tmdb.org/t/p/w500"
}
