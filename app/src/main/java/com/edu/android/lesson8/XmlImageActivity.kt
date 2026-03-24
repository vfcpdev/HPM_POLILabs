package com.edu.android.lesson8

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.edu.android.R

class XmlImageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson8_images)

        val imageView = findViewById<ImageView>(R.id.ivGlide)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // URL de una imagen para demostración (Logo Politécnico Grancolombiano o similar)
        val imageUrl = "https://www.poli.edu.co/sites/default/files/logo-poli-footer.png"

        // Carga de imagen con Glide
        Glide.with(this)
            .load(imageUrl)
            .placeholder(R.color.primary_light_blue)
            .error(R.color.sec_magenta)
            .into(imageView)

        btnBack.setOnClickListener { finish() }
    }
}
