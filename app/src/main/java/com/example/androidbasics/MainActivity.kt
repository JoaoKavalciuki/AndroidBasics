package com.example.androidbasics


import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.app.TaskStackBuilder


import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    //Both Channel name and ID must be unique for each notification
    val CHANNEL_NAME = "firstChannelName"
    val CHANNEL_ID = "firstChannelID"
    val NOTIFICATION_ID = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createNotificationChannel()

        val baseIntent = Intent(this, MainActivity::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run{
            addNextIntentWithParentStack(baseIntent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val notification = NotificationCompat.Builder(this, CHANNEL_ID)
            .setContentTitle("Android Basics")
            .setContentText("Check out your data saved with shared preferences")
            .setSmallIcon(R.drawable.ic_person)
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setContentIntent(pendingIntent)

            .build()

        val notificationManager = NotificationManagerCompat.from(this)


        val delayTimeForNotify: Long = 30000

        val sharedPreference = getSharedPreferences("privateSharedPref", MODE_PRIVATE)

        val sharedPrefEditor = sharedPreference.edit()

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
                Handler(Looper.getMainLooper()).postDelayed({
                    notificationManager.notify(NOTIFICATION_ID, notification)
                }, delayTimeForNotify)

            } catch (error: IllegalArgumentException){
                Toast.makeText(this, "This field must be filled with numbers only", Toast.LENGTH_SHORT).show()
                throw IllegalArgumentException("This field must be filled with numbers only")
            }
        }

        btnLoad.setOnClickListener {
            val name = sharedPreference.getString("name", null)
            val occupation = sharedPreference.getString("occupation", null)
            val age = sharedPreference.getInt("age", 0)

            etName.setText(name)
            etOccupation.setText(occupation)
            etAge.setText(age.toString())
        }
    }

    private fun createNotificationChannel(){

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_HIGH).apply {
                lightColor = Color.BLUE
                enableLights(true)
            }

            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}
