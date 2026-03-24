package com.edu.android

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CodeExplanationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExplanationScreen()
        }
    }
}

@Composable
fun ExplanationScreen() {
    val context = LocalContext.current
    val explanations = listOf(
        ExplanationData("¿Qué es una Activity?", "Es el componente básico de entrada de una aplicación Android. Representa una ventana única con una interfaz de usuario integrada (como una pantalla)."),
        ExplanationData("¿Qué es un Fragment?", "Es una parte modular de la interfaz de usuario dentro de una actividad. Tiene su propio ciclo de vida e interfaz, permitiendo crear aplicaciones adaptables a tablets y móviles."),
        ExplanationData("L1: Hola Mundo", "XML: Usa TextView. Compose: Usa la función Text(). El punto clave es setContentView() vs setContent{}."),
        ExplanationData("L2: Contador (Estado)", "XML: Manejo manual de listeners y actualización de UI. Compose: Uso de remember y mutableStateOf para reactividad."),
        ExplanationData("L3: Listas Dinámicas", "XML: Requiere Adapter y ViewHolder (complejo). Compose: Usa LazyColumn, mucho más legible y rápido de implementar."),
        ExplanationData("L4: Gestión Tareas", "Une estados mutables con listas. Demuestra cómo limpiar un campo de texto tras añadir un elemento."),
        ExplanationData("L5: Controles Form.", "Demuestra Checkbox, Switch y RadioButtons. Clave: en Compose, el estado del control debe ser manejado por 'onCheckedChange'."),
        ExplanationData("L6: Tipos de Layouts", "Vertical (Column/LinearLayout), Horizontal (Row/LinearLayout horizontal) y Capas (Box/FrameLayout)."),
        ExplanationData("L7: Navegación", "XML: Intents explícitos para cambiar actividad y supportFragmentManager para fragmentos. Compose: Navegación declarativa."),
        ExplanationData("L8: Imágenes", "XML utiliza Glide para descargar desde red. Compose utiliza Coil. Ambas requieren permisos de Internet."),
        ExplanationData("L9: Persistencia", "Uso de SharedPreferences para guardar datos que sobreviven al cierre de la aplicación.")
    )

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Manual de Conceptos y Código", fontSize = 24.sp, fontWeight = FontWeight.Bold, color = Color(0xFF0F385A))
        Text("Explicación detallada de cada módulo", fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(bottom = 16.dp))

        LazyColumn(modifier = Modifier.weight(1f)) {
            items(explanations) { item ->
                Card(
                    modifier = Modifier.fillMaxWidth().padding(vertical = 8.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.secondaryContainer.copy(alpha = 0.3f))
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(item.title, fontWeight = FontWeight.Bold, fontSize = 18.sp, color = Color(0xFF1FB2DE))
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(item.content, fontSize = 14.sp)
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = { (context as? Activity)?.finish() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0F385A))
        ) {
            Text("Regresar al Panel Principal")
        }
    }
}

data class ExplanationData(val title: String, val content: String)
