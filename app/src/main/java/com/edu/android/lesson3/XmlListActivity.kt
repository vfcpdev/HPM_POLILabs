package com.edu.android.lesson3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edu.android.R

/**
 * Lección 3 (XML): Listas Dinámicas con RecyclerView.
 * Este enfoque requiere un Adapter y un ViewHolder para reciclar las vistas de las filas.
 */
class XmlListActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson3_xml)

        // 1. Datos de ejemplo
        val items = List(50) { "Elemento de Lista #$it" }

        // 2. Referencia al RecyclerView del layout
        val recyclerView = findViewById<RecyclerView>(R.id.rvDynamicList)
        
        // 3. Configurar el LayoutManager (Cómo se posicionan los elementos)
        recyclerView.layoutManager = LinearLayoutManager(this)
        
        // 4. Asignar el adaptador personalizado
        recyclerView.adapter = MyAdapter(items)
    }
}
