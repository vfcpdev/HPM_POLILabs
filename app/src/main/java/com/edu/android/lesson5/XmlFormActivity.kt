package com.edu.android.lesson5

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.edu.android.R

class XmlFormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson5_xml)

        val cbTerms = findViewById<CheckBox>(R.id.cbTerms)
        val swDarkMode = findViewById<Switch>(R.id.swDarkMode)
        val rgGender = findViewById<RadioGroup>(R.id.rgGender)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val tvStatus = findViewById<TextView>(R.id.tvStatus)
        val btnBack = findViewById<Button>(R.id.btnBack)

        btnSubmit.setOnClickListener {
            val terms = if (cbTerms.isChecked) "Aceptado" else "No aceptado"
            val darkMode = if (swDarkMode.isChecked) "Activado" else "Desactivado"
            val selectedId = rgGender.checkedRadioButtonId
            val gender = if (selectedId != -1) findViewById<RadioButton>(selectedId).text else "No seleccionado"

            tvStatus.text = "Resultados:\nTérminos: $terms\nModo Oscuro: $darkMode\nGénero: $gender"
            Toast.makeText(this, "Datos Procesados con éxito", Toast.LENGTH_SHORT).show()
        }

        btnBack.setOnClickListener { finish() }
    }
}
