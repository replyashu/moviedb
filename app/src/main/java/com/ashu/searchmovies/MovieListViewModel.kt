package com.ashu.searchmovies

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.ashu.searchmovies.model.MediaEntity
import com.ashu.searchmovies.model.SearchItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieListViewModel(val repository: MovieListRepository) : ViewModel() {

    fun getMovieList(movieName: String, key: String): LiveData<PagedList<SearchItem>> {
        return repository.getMovieList(movieName, key)
    }

    fun getEntity(movieId: String): LiveData<MediaEntity> {
        return repository.getEntity(movieId)
    }

    fun saveMovieDetailsRecord(mediaEntity: MediaEntity) {
        repository.saveMovieDetailsRecord(mediaEntity)
    }

    fun fetchMovieDetails(
        movieName: String,
        plot: String,
        key: String
    ): MutableLiveData<MediaEntity> {

        val moviesListResponse: MutableLiveData<MediaEntity> = MutableLiveData()
        val observable = repository.fetchMovieDetails(movieName, plot, key)

        observable.map<MediaEntity> {
            //saveMovieDetailsRecord(it)
            it
        }.subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                {
                    moviesListResponse.value = it
                },
                {
                    moviesListResponse.value = null
                })

        return moviesListResponse
    }
}