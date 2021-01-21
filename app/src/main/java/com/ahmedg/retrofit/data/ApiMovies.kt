package com.ahmedg.retrofit.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiMovies {

    private val BASE_URL: String = "https://api.themoviedb.org/"
    val movies = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}