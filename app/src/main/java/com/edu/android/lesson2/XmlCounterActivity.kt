package com.edu.android.lesson2 // Paquete organizativo de la lección 2

import android.os.Bundle // Objeto empaquetador para el ciclo de vida
import android.widget.Button // Referencia a la clase abstracta de la vista "Button" de Android nativo
import android.widget.TextView // Referencia a la clase encargada de pintar y alojar texto de una vista regular
import androidx.appcompat.app.AppCompatActivity // Capa base para compatibilidad con widgets viejos en Android
import com.edu.android.R // Referencia al listado "Resources" auto-generado por el sistema R.java

// Pantalla tradicional donde manejamos el contador interactivo usando XML
class XmlCounterActivity : AppCompatActivity() {
    
    // Una simple variable entera guardada en memoria. Actúa como el Estado primitivo en XML (Sin inyección Reactiva)
    private var count = 0

    // Método que Android invoca al construir tu pantalla.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Ejecución del OS (preparar memoria/registros)
        
        // Define que la UI de esta pantalla estará construida con base a un archivo XML "activity_lesson2_xml".
        setContentView(R.layout.activity_lesson2_xml)

        // Android escanea ("encuentra por su ID") el XML asimilado para inyectar su entidad TextView a la variable `tvCounter`.
        val tvCounter = findViewById<TextView>(R.id.tvCounter)
        
        // Busca en la vista construida el XML con ID "btnIncrement" y lo aloja en variable de Kotlin en memoria operativa
        val btnIncrement = findViewById<Button>(R.id.btnIncrement)

        // Engancha o "escucha" un evento cada vez que un humano presiona digitalmente el botón físico o virtual btnIncrement
        btnIncrement.setOnClickListener {
            count++ // Lógicamente le sumamos '1' a la variable de Kotlin. (¡Pero esto no actualiza el pixel de la pantalla!)
            
            // ACTUALIZACIÓN IMPERATIVA: Forzamos explícitamente a la Vista de texto a reemplazar un viejo texto por el nuevo.
            tvCounter.text = count.toString()
        }
    }
}
