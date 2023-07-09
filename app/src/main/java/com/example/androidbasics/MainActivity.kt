package com.example.androidbasics




import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.androidbasics.service.PlaySongService
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnStart.setOnClickListener {
            startService(Intent(this, PlaySongService::class.java))
        }

        btnStop.setOnClickListener {
            stopService(Intent(this, PlaySongService::class.java))
        }
    }
}
