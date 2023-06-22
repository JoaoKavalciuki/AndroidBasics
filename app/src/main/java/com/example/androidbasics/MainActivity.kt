package com.example.androidbasics

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.util.Log.WARN
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager



class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val addContactDialog = AlertDialog.Builder(this)
            .setTitle("Add Person to contacts list")
            .setMessage("Do you want to add this person to your contact list?")
            .setIcon(R.drawable.ic_add_contact)
            .setPositiveButton("Yes") { _, _ ->
                Toast.makeText(this, "You add this person to the contacts list.", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") {_, _ ->
                Toast.makeText(this, "You do not add this person to the contacts list.", Toast.LENGTH_SHORT).show()
            }.create()


        val btnContactDialog = findViewById<Button>(R.id.btnDialog1)
        btnContactDialog.setOnClickListener {
            addContactDialog.show()
        }

        val options = arrayOf<String>("Top laner", "Jungler", "Mid laner", "Ad carry", "Support")

        val singleChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose your main role in League of Legends")
            .setSingleChoiceItems(options, 0) { dialogInterface, i ->
                Toast.makeText(this, "You choosed ${options[i]} as your main lane", Toast.LENGTH_SHORT).show()

            }
            .setPositiveButton("Confirm") { _, _ ->
                Toast.makeText(this, "You confirmed your main lane ", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("No") {_, _ ->
                Toast.makeText(this, "You didn't confirm your main line", Toast.LENGTH_SHORT).show()
            }.create()

        val btnSingleChoiceDialog = findViewById<Button>(R.id.btnDialog2)

        btnSingleChoiceDialog.setOnClickListener {
            singleChoiceDialog.show()
        }

        val sideDishes = arrayOf("Mustard", "Ketchup", "Barbecue")
        val multiChoiceDialog = AlertDialog.Builder(this)
            .setTitle("Choose your order side dishes, leave unchecked for no side dishes")
            .setMultiChoiceItems(sideDishes, booleanArrayOf(false, false, false)) { _, i, isChecked -> // lambda params are dialogInterface, i and isChecked
                if(isChecked) {
                    Toast.makeText(this, "Tou selected ${sideDishes[i]}", Toast.LENGTH_SHORT).show()
                }
            }
            .setPositiveButton("Confirm"){ _,_ ->
                    Toast.makeText(
                        this, "Side dishes ordered", Toast.LENGTH_SHORT).show()
            }
            .setNegativeButton("Cancel"){ _, _ ->
                Toast.makeText(this, "Side dishes order cancelled", Toast.LENGTH_SHORT).show()
            }. create()

        //all lambdas params are dialogInterface and i

        val btnMultipleChoiceDialog = findViewById<Button>(R.id.btnDialog3)
        btnMultipleChoiceDialog.setOnClickListener {
            multiChoiceDialog.show()
        }
    }
}
