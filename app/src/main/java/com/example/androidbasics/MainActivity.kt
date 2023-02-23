package com.example.androidbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnOrder : Button = findViewById(R.id.btnOrder)
        btnOrder.setOnClickListener {
            val meatsRadioGroup = findViewById<RadioGroup>(R.id.rgMeat)
            val meat = findViewById<RadioButton>(meatsRadioGroup.checkedRadioButtonId)
            val cheese = findViewById<CheckBox>(R.id.cbCheese).isChecked
            val salad = findViewById<CheckBox>(R.id.cbSalad).isChecked
            val onions = findViewById<CheckBox>(R.id.cbOnions).isChecked
            val orderString = "Your order is a hamburger with:\n" +
                    "${meat.text}\n" +
                    (if(cheese)  "Cheese\n" else "") +
                    (if(salad) "Salad\n" else "") +
                    (if (onions) "Onions" else "")
            val textView = findViewById<TextView>(R.id.tvOrder)
            textView.text = orderString
        }
    }
}