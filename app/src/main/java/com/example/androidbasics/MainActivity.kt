package com.example.androidbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnAdd : Button = findViewById(R.id.btnAdd)
        var count = 0
        btnAdd.setOnClickListener {

            val textCount: TextView = findViewById(R.id.tvAdd)
            textCount.text = "$count"
            count++
            if(count == 10) count = 0
        }
    }
}