package com.example.taskproject.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object PostHelper {
//https://jsonplaceholder.typicode.com/posts
    val BASE_URL = "https://jsonplaceholder.typicode.com"

    fun getInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}