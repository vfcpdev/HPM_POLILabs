package com.edu.android.lesson7

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.edu.android.R

class XmlFragmentsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson7_fragments)

        val etName = findViewById<EditText>(R.id.etName)
        val btnNext = findViewById<Button>(R.id.btnNextActivity)
        val btnToggle = findViewById<Button>(R.id.btnToggleFragment)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // 1. Navegación entre Actividades
        btnNext.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("EXTRA_MESSAGE", etName.text.toString())
            startActivity(intent)
        }

        // 2. Fragment Transactions (Cargar fragmento dinámicamente)
        btnToggle.setOnClickListener {
            // FragmentManager permite manipular fragmentos
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, MyFragment())
                .commit()
        }

        btnBack.setOnClickListener { finish() }
    }
}
