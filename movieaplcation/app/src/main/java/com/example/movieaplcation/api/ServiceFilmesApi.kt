package com.example.movieaplcation.api

import com.example.movieaplcation.model.FilmeResposta
import retrofit2.Response
import retrofit2.http.GET

interface ServiceFilmesApi {

    @GET("movie/popular?api_key=${RetrofitHelper.API_KEY}&language=en-US&page=1")
    suspend fun getFilmesApi(): Response<FilmeResposta>;
}