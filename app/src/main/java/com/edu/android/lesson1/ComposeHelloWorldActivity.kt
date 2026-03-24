package com.edu.android.lesson1 // Parte de la lección 1

import android.os.Bundle 
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier 
import androidx.compose.ui.unit.dp 
import androidx.compose.ui.unit.sp 

// Pantalla para Hola Mundo con Compose moderno
class ComposeHelloWorldActivity : ComponentActivity() {
    
    // Inicio del ciclo de vida
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llamada mandatoria al padre heredado
        
        // Sustituye el uso de 'setContentView' (XML). Inicia el marco visual de Compose.
        setContent {
            // Un componente Column organiza a sus hijos verticalmente
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                // UI declarativa que muestra un texto.
                Text("¡Hola Mundo desde Compose!", fontSize = 24.sp)
                
                // Espacio entre componentes
                Spacer(modifier = Modifier.height(32.dp))
                
                // Botón moderno de Compose
                Button(onClick = { 
                    finish() // Finalizar la actividad (Regresar al menú)
                }) {
                    Text("Volver al Menú Principal")
                }
            }
        }
    }
}
