package com.example.androidbasics.database.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.androidbasics.database.models.User

@Dao
interface UserDao {
    @Insert
    suspend fun addUser(user: User)



    @Query("SELECT COUNT(id) FROM tb_user")
    suspend fun getTotalUsers(): Long
}