package com.example.androidbasics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidbasics.database.AppDatabase
import com.example.androidbasics.database.daos.UserDao
import com.example.androidbasics.database.models.User
import com.example.androidbasics.databinding.ActivityNewUserBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class NewUserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewUserBinding
    private lateinit var database: AppDatabase
    private lateinit var userDao: UserDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.binding = ActivityNewUserBinding.inflate(layoutInflater)
        setContentView(this.binding.root)

        this.database = AppDatabase.getInstance(this)
        this.userDao = database.userDao()
    }

    override fun onStart() {
        super.onStart()
        this.binding.btnSave.setOnClickListener {
            CoroutineScope(Dispatchers.IO).launch {
                val result = saveUser(
                    binding.etFirstName.text.toString(),
                    binding.etLastName.text.toString()
                )

                withContext(Dispatchers.Main){
                    Toast.makeText(this@NewUserActivity,
                        if(result) "User Saved"; else "Error trying to save the user",
                        Toast.LENGTH_LONG
                    ).show()

                    if(result) finish()
                }
            }
        }
    }

    private suspend fun saveUser(firstName: String, lastName: String): Boolean {
        if (firstName.isEmpty() || firstName.isBlank()) return false

        if(lastName.isEmpty() || lastName.isBlank()) return false
        this.userDao.addUser(User(firstName, lastName))
        return true
    }
}