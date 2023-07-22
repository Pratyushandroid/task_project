package com.example.taskproject.api


import com.example.taskproject.PostsItem
import retrofit2.Response
import retrofit2.http.GET

interface PostApi {

    @GET("/posts")
    suspend fun getPost(): Response<List<PostsItem>>
}