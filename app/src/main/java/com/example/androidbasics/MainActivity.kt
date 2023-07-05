package com.example.androidbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast



import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val sharedPrefence = getSharedPreferences("privateSharedPref", MODE_PRIVATE)

        val sharedPrefEditor = sharedPrefence.edit()

        btnSave.setOnClickListener {
            val name = etName.text.toString()
            val occupation = etOccupation.text.toString()

            try{
                val age = etAge.text.toString().toInt()
                sharedPrefEditor.apply{
                    putString("name", name)
                    putString("occupation", occupation)
                    putInt("age", age)
                    apply()
                }
                Toast.makeText(this, "Your data has been saved", Toast.LENGTH_SHORT).show()
            } catch (error: IllegalArgumentException){
                Toast.makeText(this, "This field must be filled with numbers only", Toast.LENGTH_SHORT).show()
                throw IllegalArgumentException("This field must be filled with numbers only")
            }
        }

        btnLoad.setOnClickListener {
            val name = sharedPrefence.getString("name", null)
            val occupation = sharedPrefence.getString("occupation", null)
            val age = sharedPrefence.getInt("äge", 0)

            etName.setText(name)
            etOccupation.setText(occupation)
            etAge.setText(age.toString())
        }
    }
}
