package com.ahmedg.retrofit.data

import com.ahmedg.retrofit.model.MoviesPogoResult
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface IApiMovies {
    @GET("/3/movie/upcoming")
    fun getMovies(@Query("api_key") key: String): Call<MoviesPogoResult>
}