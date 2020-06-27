package com.ashu.searchmovies.di.module

import androidx.room.Room
import com.ashu.searchmovies.MovieApplication
import com.ashu.searchmovies.db.MediaDao
import com.ashu.searchmovies.db.MediaDatabase
import com.ashu.searchmovies.db.MediaLocalCache
import com.ashu.searchmovies.di.BaseUrl
import dagger.Module
import dagger.Provides
import java.util.concurrent.Executors
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @BaseUrl
    fun provideBaseUrl(): String {
        return "http://www.omdbapi.com"
    }

    @Provides
    @Singleton
    fun provideMediaDatabase(application: MovieApplication): MediaDatabase {
        return Room.databaseBuilder(application, MediaDatabase::class.java, "media.db").build()
    }

    @Provides
    @Singleton
    fun provideMediaDao(database: MediaDatabase): MediaDao {
        return database.mediaDao()
    }

    @Provides
    @Singleton
    fun provideMediaLocalCache(database: MediaDatabase): MediaLocalCache {
        return MediaLocalCache(database.mediaDao(), Executors.newSingleThreadExecutor())
    }
}