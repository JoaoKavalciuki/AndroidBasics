package com.example.androidbasics

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.util.Log.WARN
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnRequestPermission: Button = findViewById(R.id.btnRequestPermission)
        btnRequestPermission.setOnClickListener {
            requestPermissions.launch(arrayOf(Manifest.permission.CAMERA, Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_BACKGROUND_LOCATION, Manifest.permission.RECORD_AUDIO))
        }
    }

    //Verifica se a permissão foi garantida ou não através do contrato
    private val requestPermissions =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){
           it.forEach{
               if(it.value)Log.i("Permission", "Permission ${it.key} granted")
                else Log.w("Permission", "Permission ${it.key} not granted")
           }

        }
}
