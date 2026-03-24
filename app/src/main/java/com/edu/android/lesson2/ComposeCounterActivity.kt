package com.edu.android.lesson2

import android.os.Bundle
import androidx.activity.ComponentActivity // Heredamos de la clase moderna
import androidx.activity.compose.setContent // API puente
import androidx.compose.foundation.layout.Arrangement // Manejo de centrado vertical
import androidx.compose.foundation.layout.Column // Componente organizativo (Linear Layout en modo Vertical de XML)
import androidx.compose.foundation.layout.Spacer // Elemento vacio invisible
import androidx.compose.foundation.layout.fillMaxSize // Modificador
import androidx.compose.foundation.layout.height // Modificador espacial
import androidx.compose.material3.Button // Componente oficial interactivo del Botón M3
import androidx.compose.material3.Text // Entidad base textual Compose
import androidx.compose.runtime.Composable // Anotador léxico para indicarle al compilador cómo montar los nodos de elementos
import androidx.compose.runtime.getValue // Para desestructurar getters de MutableState
import androidx.compose.runtime.mutableStateOf // Wrapper base que Android Compose usa para Vigilar el Estado (Detecta si una variable muta)
import androidx.compose.runtime.remember // Garantiza que una variable no sufra pérdida cuando una pantalla gira, o se redibuja debido a cambios
import androidx.compose.runtime.setValue // Setter delegado (opcional pero usual si queremos editar sin llamar el getter)
import androidx.compose.ui.Alignment 
import androidx.compose.ui.Modifier 
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp 
import androidx.compose.ui.unit.sp 
import android.app.Activity

// Ventana o Actividad dedicada enteramente a Reactividad vía Jetpack Compose
class ComposeCounterActivity : ComponentActivity() {
    
    // Método ciclo de vida principal.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Bloque raíz Compose que inicializamos para arrancar la UI
        setContent {
            // Llamamos indirectamente una "función @Composable" construida fuera de la clase.
            CounterScreen()
        }
    }
}

// Una función declarativa reactiva. Devuelve un árbol de la UI en base al Estado
@Composable
fun CounterScreen() {
    // ESTADO REACTIVO: Compose *escucha* esta variable.
    // 'remember': guarda '0' entre recálculos (recomposiciones). 
    // 'mutableStateOf': le notifica a Android Studio cuand es modificada, forzando a re-dibujar las partes de "CounterScreen" que leen `count`.
    var count by remember { mutableStateOf(0) }

    // Column: Apila elementos verticalmente
    Column(
        modifier = Modifier.fillMaxSize(), // Toma el ancho/alto de pantalla
        verticalArrangement = Arrangement.Center, // Espaciado y orden vertical: Centrado absoluto
        horizontalAlignment = Alignment.CenterHorizontally // Alinear elementos hijos en el eje transversal(Horizontal): Al centro
    ) {
        // Compose pinta textualizando el estado reactivo 'count' referenciado aquí en tiempo de invocación.
        Text(text = "$count", fontSize = 64.sp)
        
        // Elemento invisible que separa el texto del botón unos 24dp lógicos
        Spacer(modifier = Modifier.height(24.dp))
        
        Button(onClick = { 
            count++ // Al alterar esta variable de MutableStateOf, Compose redibuja mágicamente toda la parte UI que esté atada a el. ¡No asignamos la view nunca manual!
        }) {
            // Textura visual e interna del botón
            Text("INCREMENTAR (COMPOSE)")
        }

        Spacer(modifier = Modifier.height(32.dp))

        val context = LocalContext.current
        Button(onClick = { 
            (context as? Activity)?.finish()
        }) {
            Text("Volver al Menú Principal")
        }
    }
}
