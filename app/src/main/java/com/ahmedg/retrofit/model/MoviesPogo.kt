package com.ahmedg.retrofit.model

data class MoviesPogoResult(
    val results: List<Result>
)

data class Result(
    val id: Int,
    val popularity: Double,
    val backdrop_path: String,
    val release_date: String,
    val original_title: String,
    )
