package com.ashu.searchmovies.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ashu.searchmovies.model.MediaEntity
import com.ashu.searchmovies.model.RatingsConverter

@TypeConverters(RatingsConverter::class)
@Database(entities = [MediaEntity::class], version = 1,exportSchema = false)
abstract class MediaDatabase : RoomDatabase() {
    abstract fun mediaDao(): MediaDao
}