package com.example.androidbasics

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnRequest: Button = findViewById(R.id.btnPermission)
        btnRequest.setOnClickListener { permissionsToAsk() }

    }

    private fun hasForegroundLocation() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun hasBackGroundLocation() =
        ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED

    @RequiresApi(Build.VERSION_CODES.Q)
    private fun permissionsToAsk(){
        val hasNotPermission = mutableListOf<String>()
        //Allow all the time
        if(!hasBackGroundLocation()) hasNotPermission.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        //Allow while using the app
        if(!hasForegroundLocation()) hasNotPermission.add(Manifest.permission.ACCESS_COARSE_LOCATION)

        if(hasNotPermission.isNotEmpty()){
            ActivityCompat.requestPermissions(this, hasNotPermission.toTypedArray(), 0)
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 0 && grantResults.isNotEmpty()){
            for(i in grantResults.indices){
                if(grantResults[i] == PackageManager.PERMISSION_GRANTED) Log.d("RequestedPermission", "${permissions[i]} accepted")
                else Log.w("RequestedPermission", "${permissions[i]} denied")
            }
        }
    }
}