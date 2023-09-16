package com.example.androidbasics.viewmodel.main

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.androidbasics.models.Live
import com.example.androidbasics.repositories.MainRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel(private val repository: MainRepository): ViewModel() {
    val liveList = MutableLiveData<List<Live>>()
    val errorMessage = MutableLiveData<String>()
    fun getAllLives(){


        val request = repository.getAllLives()
        request.enqueue(object: Callback<List<Live>>{
            override fun onResponse(call: Call<List<Live>>, response: Response<List<Live>>) {
                Log.i("Test", "onResponse Log")
                liveList.postValue(response.body())
            }

            override fun onFailure(call: Call<List<Live>>, error: Throwable) {
                errorMessage.postValue(error.message)
            }

        })
    }
}