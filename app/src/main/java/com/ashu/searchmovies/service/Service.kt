package com.ashu.searchmovies.service

import com.ashu.searchmovies.model.MediaEntity
import com.ashu.searchmovies.model.MoviesListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("/")
    fun getMoviesList(
        @Query("s") movieName: String, @Query("apikey") key: String,
        @Query("page") page: Int, @Query("pageSize") pageSize: Int): Single<MoviesListResponse>

    @GET("/")
    fun getMovieDetails(
        @Query("i") id: String, @Query("plot") plot: String, @Query("apikey") key: String): Single<MediaEntity>
}
