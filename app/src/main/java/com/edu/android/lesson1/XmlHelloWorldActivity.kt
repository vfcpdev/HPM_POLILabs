package com.edu.android.lesson1 // Paquete asignado a este archivo

import android.os.Bundle // Necesario para gestionar el estado durante la creación (Lifecycle)
import androidx.appcompat.app.AppCompatActivity // Clase base para Actividades Android clásico
import com.edu.android.R // R.java es la clase generada por Android para acceder a los recursos (como layouts)

// Actividad de ejemplo Hola Mundo implementando el patrón antiguo / clásico (vistas y XML)
class XmlHelloWorldActivity : AppCompatActivity() {
    
    // Punto de entrada de la Actividad
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Ejecuta la preparación base
        
        // Asigna la interfaz de usuario guardada en 'res/layout/activity_lesson1_xml.xml' a esta ventana.
        // Android "infla" (construye en memoria) estos componentes XML.
        setContentView(R.layout.activity_lesson1_xml)
    }
}
