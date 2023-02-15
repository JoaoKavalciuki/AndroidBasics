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
            val firstName = findViewById<EditText>(R.id.etFirstName).text.toString()
            val lastName = findViewById<EditText>(R.id.etLastName).text.toString()
            val birthDate = findViewById<EditText>(R.id.etBirthDate).text.toString()
            val country =findViewById<EditText>(R.id.etCountry).text.toString()
            Log.i("MainActivity", "Name: $firstName $lastName, born on: $birthDate, nationality: $country")
        }
    }
}