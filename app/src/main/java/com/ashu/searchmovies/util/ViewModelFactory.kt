package com.ashu.searchmovies.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ashu.searchmovies.MovieListRepository
import com.ashu.searchmovies.MovieListViewModel
import javax.inject.Inject

class ViewModelFactory
    @Inject constructor(private val repository: MovieListRepository)
    : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieListViewModel::class.java) -> MovieListViewModel(repository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel Class ${modelClass.name}")
        }
    }
}