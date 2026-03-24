package com.edu.android.lesson6

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.edu.android.R

class XmlLayoutsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson6_layouts)

        findViewById<Button>(R.id.btnBack).setOnClickListener {
            finish()
        }
    }
}
