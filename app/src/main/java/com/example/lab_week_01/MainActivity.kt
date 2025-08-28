package com.example.lab_week_01

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val nameDisplay = findViewById<TextView>(R.id.name_display)
        val name_idSubmit = findViewById<Button>(R.id.name_submit)

        name_idSubmit.setOnClickListener {
            val nameInput = findViewById<TextInputEditText>(R.id.name_input) ?.text.toString().trim()
            val idInput = findViewById<TextInputEditText>(R.id.studentid_input) ?.text.toString().trim()
            if (nameInput.isEmpty()) {
                Toast.makeText(this, getString(R.string.name_empty), Toast.LENGTH_LONG).show()
                return@setOnClickListener // Exit the listener early
            }

            if (idInput.isEmpty()) {
                Toast.makeText(this, getString(R.string.id_empty), Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (!idInput.matches(Regex("\\d{11}"))) {
                // Using a more specific error message would be better
                Toast.makeText(this, getString(R.string.id_empty), Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            nameDisplay?.text = "${getString(R.string.name_greet)} ${nameInput}, ${getString(R.string.id_greet)} ${idInput}"
        }
    }
}