package com.edu.android.lesson1 // Parte de la lección 1

import android.os.Bundle // Para manejar el estado guardado
import androidx.activity.ComponentActivity // Clase base ligera (usada generalmente para Compose)
import androidx.activity.compose.setContent // Función de extensión pilar para inyectar un nodo raíz de Compose
import androidx.compose.foundation.layout.Box // Equivalente moderno a FrameLayout, pinta encima
import androidx.compose.foundation.layout.fillMaxSize // Modificador para ocupar toda la pantalla
import androidx.compose.material3.Text // Componente Text de la librería de diseño Material 3
import androidx.compose.ui.Alignment // Enum para declarar alineaciones en un Box o layout
import androidx.compose.ui.Modifier // Interfaz Modifier fundamental en Compose para alterar aspecto/tamaño
import androidx.compose.ui.unit.sp // Pixeles escalables referenciados para fuentes tipográficas

// Pantalla para Hola Mundo con Compose moderno
class ComposeHelloWorldActivity : ComponentActivity() {
    
    // Inicio del ciclo de vida
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llamada mandatoria al padre heredado
        
        // Sustituye el uso de 'setContentView' (XML). Inicia el marco visual de Compose.
        setContent {
            // Contenedor principal para organizar la vista en capas
            Box(
                // Ocupamos todo el tamaño físico de la pantalla de fondo
                modifier = Modifier.fillMaxSize(), 
                // Colocamos por defecto cualquier "hijo" visual totalmente centrado
                contentAlignment = Alignment.Center
            ) {
                // UI declarativa que escupe un texto.
                Text("¡Hola Mundo desde Compose!", fontSize = 32.sp)
            }
        }
    }
}
