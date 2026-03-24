package com.edu.android.lesson9

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.edu.android.R

class XmlPersistActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson9_persist)

        val etInput = findViewById<EditText>(R.id.etStatus)
        val btnSave = findViewById<Button>(R.id.btnSave)
        val btnWeb = findViewById<Button>(R.id.btnWeb)
        val btnShare = findViewById<Button>(R.id.btnShare)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // SharedPreferences: Acceso a disco local del dispositivo
        val prefs = getSharedPreferences("config_edu", Context.MODE_PRIVATE)

        // Recuperar dato guardado anteriormente
        val savedValue = prefs.getString("user_status", "")
        etInput.setText(savedValue)

        btnSave.setOnClickListener {
            val text = etInput.text.toString()
            prefs.edit().putString("user_status", text).apply()
            Toast.makeText(this, "Estado Guardado Correctamente", Toast.LENGTH_SHORT).show()
        }

        // Intent Implícito: Abrir Navegador
        btnWeb.setOnClickListener {
            val url = "https://www.poli.edu.co"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }

        // Intent Implícito: Compartir
        btnShare.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(Intent.EXTRA_TEXT, "¡Mira este excelente curso del Politecnico Grancolombiano!")
                type = "text/plain"
            }
            startActivity(Intent.createChooser(sendIntent, "Compartir con:"))
        }

        btnBack.setOnClickListener { finish() }
    }
}
