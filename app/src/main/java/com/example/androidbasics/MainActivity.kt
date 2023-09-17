package com.example.androidbasics

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.androidbasics.adapters.MainAdapter
import com.example.androidbasics.databinding.ActivityMainBinding
import com.example.androidbasics.repositories.MainRepository
import com.example.androidbasics.services.RetrofitService
import com.example.androidbasics.viewmodel.main.MainViewModel
import com.example.androidbasics.viewmodel.main.MainViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
