package com.example.androidbasics.database

import android.content.Context
import androidx.room.Database
import androidx.room.DatabaseConfiguration
import androidx.room.InvalidationTracker
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteOpenHelper
import com.example.androidbasics.database.daos.UserDao
import com.example.androidbasics.database.models.User

@Database(entities = [User::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun userDao(): UserDao

    companion object{
        private const val DATABASE_NAME: String = "RoomDataseExample"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context) : AppDatabase =
            INSTANCE ?: synchronized(this){
                INSTANCE ?: buildDatabase(context).also { INSTANCE = it }

        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, DATABASE_NAME
            ).build()

    }
}