package com.example.androidbasics

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
class OrdersActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_orders)
        val order = intent.getStringExtra("EXTRA_ORDER")
        val orderTextView : TextView = findViewById(R.id.tvOrder)
        orderTextView.text = order
        val btnMakeAnotherOrder : Button = findViewById(R.id.btnMakeAnotherOrder)
        btnMakeAnotherOrder.setOnClickListener { finish() }
    }
}