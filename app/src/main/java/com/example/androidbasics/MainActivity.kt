package com.example.androidbasics

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnOrder : Button = findViewById(R.id.btnOrder)

        btnOrder.setOnClickListener {

            //val textOrder : TextView = findViewById(R.id.orderText)
            val fillingTypes: RadioGroup = findViewById(R.id.rgFilling)
            val choosedFilling: RadioButton = findViewById(fillingTypes.checkedRadioButtonId)
            val fries = findViewById<CheckBox>(R.id.cbFries).isChecked
            val soda = findViewById<CheckBox>(R.id.cbSoda).isChecked
            val ketchup = findViewById<CheckBox>(R.id.cbKetchup).isChecked
            val mustard = findViewById<CheckBox>(R.id.cbMustard).isChecked
            /*val orderString = "You order a ${choosedFilling.text} burger with:\n" +
                    (if(fries.) "Fries\n" else "") +
                    (if(soda) "Soda\n" else "") +
                    (if(ketchup) "Ketchup\n" else "") +
                    (if(mustard) "and Mustard\n" else "")
            textOrder.text = orderString*/
            Toast.makeText(this, "Ordered", Toast.LENGTH_SHORT).show()
            val orderString = StringBuilder()
            orderString.append("${choosedFilling.text} burger with:\n")
            if(fries) orderString.append("Fries\n")
            if(soda) orderString.append("Soda\n")
            if(ketchup) orderString.append("Ketchup\n")
            if(mustard) orderString.append("Mustard\n")

             Intent(this, OrdersActivity::class.java).also{
                 it.putExtra("EXTRA_ORDER", orderString.toString())
                 startActivity(it)
             }
        }
    }
}