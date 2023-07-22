package com.example.taskproject.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.taskproject.PostsItem


@Database(entities = [PostsItem::class], version = 1)
abstract class PostDatabase:RoomDatabase(){

    abstract fun getDao():PostDao

    companion object{

        @Volatile
        private var Instance:PostDatabase ?=null

        fun getDatabase(context: Context):PostDatabase{
            if (Instance == null){
                synchronized(this){
                    Instance = Room.databaseBuilder(
                        context,
                        PostDatabase::class.java,
                        "quote.db"
                    ).build()
                }
            }
            return Instance!!
        }
    }
}