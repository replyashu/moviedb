package com.ashu.searchmovies.dataSource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.ashu.searchmovies.model.SearchItem
import com.ashu.searchmovies.service.Service
import io.reactivex.disposables.CompositeDisposable

class MovieDataSourceFactory(
    private val compositeDisposable: CompositeDisposable,
    private val networkService: Service,
    private val movieName: String,
    private val apiKey: String)
    : DataSource.Factory<Int, SearchItem>() {

    val newsDataSourceLiveData = MutableLiveData<MovieDataSource>()

    override fun create(): DataSource<Int, SearchItem> {
        val newsDataSource = MovieDataSource(networkService, compositeDisposable,movieName,apiKey)
        newsDataSourceLiveData.postValue(newsDataSource)
        return newsDataSource
    }
}