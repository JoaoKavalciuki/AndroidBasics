package com.example.androidbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val departureOptions = listOf("Depart now", "Set departure time", "Set arrive time",  "Latest Departure")
        val adapterDepartures = ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, departureOptions)
        val spinner: Spinner = findViewById(R.id.spFatecs)
        spinner.adapter = adapterDepartures
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{

            override fun onItemSelected(adapterView: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // @MainActivity is used here because the Toast is inside of the anonymous class, not the activity
                Toast.makeText(this@MainActivity,
                    "${adapterView?.getItemAtPosition(position).toString()} selected",
                    Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {

            }
        }
    }
}
