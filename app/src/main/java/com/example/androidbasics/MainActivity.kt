package com.example.androidbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.menu_opened, R.string.menu_closed)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val delay: Long = 1000

        navView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miAccount ->
                    Toast.makeText(this, "My Account clicked", Toast.LENGTH_SHORT).show()
                R.id.miBook ->
                    Toast.makeText(this, "My Books clicked", Toast.LENGTH_SHORT).show()
                R.id.miLogout -> {
                    Toast.makeText(this, "You clicked the logout button. The app wll be closed", Toast.LENGTH_SHORT).show()
                    Handler(Looper.getMainLooper()).postDelayed({
                        finish()
                    }, delay)
                }

            }
            true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)) return  true

        return super.onOptionsItemSelected(item)
    }
}
