package com.edu.android.lesson7

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.edu.android.R

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        // Obtener datos del intent anterior
        val data = intent.getStringExtra("EXTRA_MESSAGE")
        val tvMessage = findViewById<TextView>(R.id.tvMessage)
        tvMessage.text = "Recibí: $data"

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}
