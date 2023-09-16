package com.example.androidbasics.repositories

import com.example.androidbasics.services.RetrofitService

class MainRepository(private val retrofitService: RetrofitService) {
    fun getAllLives() = retrofitService.getAllLives()
}