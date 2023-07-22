package com.example.taskproject

import android.app.Application
import com.example.taskproject.api.PostApi
import com.example.taskproject.api.PostHelper
import com.example.taskproject.db.PostDatabase
import com.example.taskproject.repository.PostRepository

class PostApplication :Application() {
    lateinit var postRepository: PostRepository
    override fun onCreate() {
        super.onCreate()

        initialize()
    }

    private fun initialize() {

        val postApi = PostHelper.getInstance().create(PostApi::class.java)

        val postDatabase = PostDatabase.getDatabase(applicationContext)
        postRepository = PostRepository(postApi,postDatabase,applicationContext)
    }
}