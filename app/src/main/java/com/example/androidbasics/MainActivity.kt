package com.example.androidbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnAddImage : Button = findViewById(R.id.btnAddImage)
        btnAddImage.setOnClickListener {
            val image : ImageView = findViewById(R.id.ivImage)
            image.setImageResource(R.drawable.traintrip)
        }
    }
}