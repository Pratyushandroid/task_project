package com.example.taskproject.repository

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.taskproject.PostsItem
import com.example.taskproject.api.PostApi
import com.example.taskproject.db.PostDatabase
import com.example.taskproject.utils.NetworkUtils

class PostRepository (
    private val postApi:PostApi,
    private val postDatabase:PostDatabase,
    private val applicationContext: Context
    ) {
    private val postLiveData = MutableLiveData<List<PostsItem>>()
    val posts: MutableLiveData<List<PostsItem>>
        get() = postLiveData

    suspend fun getQuotes() {
        if (NetworkUtils.isInternetAvailable(applicationContext)) {
            val result = postApi.getPost()
            if (result.body() != null) {
                postDatabase.getDao().AddPost(result.body()!!)
                postLiveData.postValue(result.body())
            }
        } else {
            val posts = postDatabase.getDao().getPost()

            postLiveData.postValue(posts)

        }
    }
}