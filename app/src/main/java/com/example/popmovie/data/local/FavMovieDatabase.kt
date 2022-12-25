package com.example.popmovie.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [FavMovie::class],
    version = 1
)
abstract class FaMovieDatabase : RoomDatabase(){
    abstract fun getFavMovieDao(): FavMovieDao
}