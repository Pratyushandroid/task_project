package com.example.taskproject.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.taskproject.PostsItem

@Dao
interface PostDao {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun AddPost(post: List<PostsItem>)

        @Query("Select * From PostTable")
        suspend fun getPost(): List<PostsItem>

}