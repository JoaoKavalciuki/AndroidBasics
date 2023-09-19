package com.example.androidbasics.database.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_user")
data class User(
    var firstName: String,
    var lastName: String
){
    @PrimaryKey(autoGenerate = true, )
     var id: Long = 0L
}
