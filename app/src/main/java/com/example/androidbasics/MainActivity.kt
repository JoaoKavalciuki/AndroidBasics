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
        btnAdd.setOnClickListener {
            val numberOne: EditText = findViewById(R.id.etNumberOne)
            val numberTwo: EditText = findViewById(R.id.etNumberTwo)
            val resultTextView: TextView = findViewById(R.id.tvResult)
            resultTextView.text = "Result: ${numberOne.text.toString().toInt() + numberTwo.text.toString().toInt()}"
        }
    }
}