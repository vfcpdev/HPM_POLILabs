package com.edu.android.lesson3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Lección 3 (Compose): Listas Dinámicas con LazyColumn.
 * No requiere Adapters ni layouts XML adicionales.
 */
class ComposeListActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        // 1. Datos del ejemplo
        val items = List(50) { "Elemento de Lista #$it" }

        // 2. Establecer el contenido declarativo
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = MaterialTheme.colorScheme.background
            ) {
                MiListaGenial(elementos = items)
            }
        }
    }
}

/**
 * Composable que define la estructura de la lista.
 * Es mucho más corto que el RecyclerView de XML.
 */
@Composable
fun MiListaGenial(elementos: List<String>) {
    // 1. LazyColumn: Es el equivalente moderno para listas grandes (Renderizado flojo)
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        
        // 2. Definimos las filas dinámicamente
        items(elementos) { nombre ->
            // Definimos visualmente la celda de cada fila
            Text(
                text = nombre,
                fontSize = 18.sp,
                modifier = Modifier.padding(16.dp)
            )
        }
    }
}
