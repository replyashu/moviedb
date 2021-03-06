package com.ashu.searchmovies.dataSource

import androidx.paging.PageKeyedDataSource
import com.ashu.searchmovies.model.SearchItem
import com.ashu.searchmovies.service.Service
import io.reactivex.disposables.CompositeDisposable

class MovieDataSource(
    private val networkService: Service,
    private val compositeDisposable: CompositeDisposable,
    val movieName: String,
    val apiKey: String
) : PageKeyedDataSource<Int, SearchItem>() {

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, SearchItem>
    ) {
        compositeDisposable.add(
            networkService.getMoviesList(movieName, apiKey, 1, params.requestedLoadSize)
                .subscribe(
                    { response ->
                        response?.search?.let {
                            callback.onResult(
                                it,
                                null,
                                2
                            )
                        }
                    },
                    { it.printStackTrace()}
                )
        )
    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, SearchItem>) {
        compositeDisposable.add(
            networkService.getMoviesList(movieName, apiKey, params.key, params.requestedLoadSize)
                .subscribe(
                    { response ->
                        response?.search?.let {
                            callback.onResult(
                                it,
                                params.key + 1
                            )
                        }
                    },
                    { it.printStackTrace() }
                )
        )
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, SearchItem>) {
    }
}