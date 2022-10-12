package com.example.movieaplcation.api
import  retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

class RetrofitHelper {

    companion object {
       // const val API_KEY ="46bab2f382fc37a6fd305e26d885ba46"
          const val API_KEY ="518992ade1aa45f07f66cc2d8d4c5a83"

        val api = Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    }
}