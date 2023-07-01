package com.example.androidbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidbasics.fragments.FirstFragment
import com.example.androidbasics.fragments.SecondFragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()

        supportFragmentManager.beginTransaction().apply{
            replace(R.id.flFragment, firstFragment)
            addToBackStack("First Fragment")
            commit()
        }

        btnFragment1.setOnClickListener {
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.flFragment, firstFragment)
                addToBackStack("Second Fragment")
                commit()
            }
        }

        btnFragment2.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.flFragment, secondFragment)
                commit()
            }
        }
    }
}
