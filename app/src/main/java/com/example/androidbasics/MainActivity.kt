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
    lateinit var viewModel : MainViewModel

    private val retrofitService = RetrofitService.getInstance()
    private val adapter = MainAdapter{
        openLink(it.link)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        viewModel = ViewModelProvider(this,
            MainViewModelFactory(MainRepository(retrofitService)))[MainViewModel::class.java]

        binding.rv.adapter = adapter
    }

    override fun onStart() {
        super.onStart()
        viewModel.liveList.observe(this, Observer{lives ->
            Log.i("Test", "Live list observable Log")
            adapter.setLiveList(lives)
        })

        viewModel.errorMessage.observe(this, Observer { message ->
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        })
    }

    override fun onResume() {
        super.onResume()
        viewModel.getAllLives()
        Log.i("Test", "onResume Log")
    }

    private fun openLink(link: String){
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
        startActivity(browserIntent)
    }
}
