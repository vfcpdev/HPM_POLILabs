package com.edu.android.lesson4

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edu.android.R
import com.edu.android.lesson3.MyAdapter

/**
 * Lección 4 (XML): Aplicación Completa (To-Do List).
 * Integra estados, eventos click y listas dinámicas en un flujo manual.
 */
class XmlTodoActivity : AppCompatActivity() {
    
    // 1. Datos del modelo (Lista mutable de tareas)
    private val misDatos = mutableListOf<String>()
    private lateinit var adapter: MyAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lesson4_xml)

        // 2. Referencia a las vistas
        val field = findViewById<EditText>(R.id.etInput)
        val btn = findViewById<Button>(R.id.btnSave)
        val recycler = findViewById<RecyclerView>(R.id.rvTasks)

        // 3. Inicializar el RecyclerView y su adaptador
        adapter = MyAdapter(misDatos)
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        // 4. Configurar el evento de clic para guardar la tarea
        btn.setOnClickListener {
            val text = field.text.toString()
            if (text.isNotEmpty()) {
                // Agregar dato a la lista real
                misDatos.add(text)
                
                // FUNDAMENTAL: Informar a Android del cambio:
                // Sin esto, la pantalla no se enteraría que hay una nueva fila
                adapter.notifyItemInserted(misDatos.size - 1)
                
                // Limpiar campo de texto para el próximo ingreso
                field.text.clear()
            }
        }
    }
}
