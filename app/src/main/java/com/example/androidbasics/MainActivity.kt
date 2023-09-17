package com.example.androidbasics

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidbasics.adapters.MainAdapter
import com.example.androidbasics.databinding.ActivityMainBinding
import com.example.androidbasics.models.LanguagesMockDataSet
import com.example.androidbasics.models.MobileLanguage


class MainActivity : AppCompatActivity() {


    private lateinit var mainAdapter: MainAdapter
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onStart() {
        super.onStart()
        initRecyclerView()
        addDataSource()
    }

    private fun initRecyclerView(){
        mainAdapter = MainAdapter({mobileLanguage ->
            openLink(mobileLanguage.link)
        }, this.binding)

        binding.rvLanguages.apply{
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }
    }

    private fun openLink(url: String){
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }
    private fun addDataSource() {

        val dataSet = LanguagesMockDataSet.createDataSet()
        mainAdapter.setLanguagesList(dataSet)
    }

}
