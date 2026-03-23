package com.edu.android.lesson4

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * Lección 4 (Compose): Aplicación Completa (To-Do List).
 * Todo el flujo es reactivo: La lista se actualiza sola al mutar `tasks`.
 */
class ComposeTodoActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                TodoScreen()
            }
        }
    }
}

/**
 * Pantalla completa de Tareas con manejo reactivo de estado.
 */
@Composable
fun TodoScreen() {
    // 1. Estados reactivos: Mutan la UI directamente
    val tasks = remember { mutableStateListOf<String>() } // Lista Observable
    var input by remember { mutableStateOf("") }         // Texto de entrada reactivo

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Row {
            // 2. Campo de Texto Outlined
            OutlinedTextField(
                value = input,
                onValueChange = { input = it }, // Actualiza el estado reactivo 'input'
                label = { Text("Escribe una tarea...") },
                modifier = Modifier.weight(1f)
            )

            // 3. Botón de guardado
            Button(
                onClick = { 
                    if (input.isNotEmpty()) {
                        tasks.add(input) // Agrega dato y la LazyColumn se repinta sola
                        input = ""       // Limpiar para la próxima tarea
                    }
                },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Text("Guardar")
            }
        }

        // 4. Lista Dinámica Reactiva (LazyColumn)
        // No necesita Adapters ni ViewHolders.
        LazyColumn(modifier = Modifier.padding(top = 16.dp)) {
            items(tasks) { taskName ->
                Text(
                    text = "Tarea: $taskName",
                    modifier = Modifier.padding(vertical = 8.dp)
                )
            }
        }
    }
}
