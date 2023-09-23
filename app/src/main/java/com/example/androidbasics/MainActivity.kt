package com.example.androidbasics

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidbasics.database.AppDatabase
import com.example.androidbasics.database.daos.UserDao

import com.example.androidbasics.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding
    private lateinit var  userDao: UserDao
    private lateinit var appDatabase: AppDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        this.appDatabase = AppDatabase.getInstance(this)
        this.userDao = appDatabase.userDao()
        CoroutineScope(Dispatchers.IO).launch {
            val usersRegistered = userDao.getTotalUsers()

            withContext(Dispatchers.Main){
            binding.tvUsersQuantity.text = "Users registered untill now: $usersRegistered"
            }
        }

        this.binding.btnNewUser.setOnClickListener {
            startActivity(Intent(this, NewUserActivity::class.java))
        }
    }

}
