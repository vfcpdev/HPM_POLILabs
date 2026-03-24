package com.edu.android

import android.content.Intent
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import android.os.Bundle
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.launch
import com.edu.android.lesson1.*
import com.edu.android.lesson2.*
import com.edu.android.lesson3.*
import com.edu.android.lesson4.*
import com.edu.android.lesson5.*
import com.edu.android.lesson6.*
import com.edu.android.lesson7.*

class MainActivity : androidx.activity.ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DashboardScreen()
        }
    }
}

@Composable
fun DashboardScreen() {
    val context = LocalContext.current
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Encabezado Moderno
        Text("Explorador Educativo Android", fontSize = 28.sp, color = MaterialTheme.colorScheme.primary, modifier = Modifier.padding(bottom = 8.dp))
        Text("Tradicional XML vs Moderno Compose", fontSize = 16.sp, color = MaterialTheme.colorScheme.secondary, modifier = Modifier.padding(bottom = 24.dp))

        // Botón Tutorial Interactivo
        LessonCard(
            title = "Tutorial Interactivo",
            description = "Antes de empezar, aprende la teoría.",
            icon = Icons.Default.Info,
            onClick = { context.startActivity(Intent(context, InteractiveTutorialActivity::class.java)) },
            color = MaterialTheme.colorScheme.tertiaryContainer
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Lección 1
        DualLessonCard("Lección 1: Hola Mundo", "Conceptos básicos de texto.", 
            onXml = { context.startActivity(Intent(context, XmlHelloWorldActivity::class.java)) },
            onCompose = { context.startActivity(Intent(context, ComposeHelloWorldActivity::class.java)) })

        // Lección 2
        DualLessonCard("Lección 2: Estados", "Manejo de contadores y clicks.", 
            onXml = { context.startActivity(Intent(context, XmlCounterActivity::class.java)) },
            onCompose = { context.startActivity(Intent(context, ComposeCounterActivity::class.java)) })

        // Lección 3
        DualLessonCard("Lección 3: Listas Dinámicas", "RecyclerView vs LazyColumn.", 
            onXml = { context.startActivity(Intent(context, XmlListActivity::class.java)) },
            onCompose = { context.startActivity(Intent(context, ComposeListActivity::class.java)) })

        // Lección 4
        DualLessonCard("Lección 4: Mini App Final", "Integración de componentes.", 
            onXml = { context.startActivity(Intent(context, XmlTodoActivity::class.java)) },
            onCompose = { context.startActivity(Intent(context, ComposeTodoActivity::class.java)) })

        // NUEVA Lección 5
        DualLessonCard("Lección 5: Controles Form.", "Checkbox, Switch, RadioGroup.", 
            onXml = { context.startActivity(Intent(context, XmlFormActivity::class.java)) },
            onCompose = { context.startActivity(Intent(context, ComposeFormActivity::class.java)) })

        // NUEVA Lección 6
        DualLessonCard("Lección 6: Tipos de Layouts", "Vertical, Horizontal y Capas.", 
            onXml = { context.startActivity(Intent(context, XmlLayoutsActivity::class.java)) },
            onCompose = { context.startActivity(Intent(context, ComposeLayoutsActivity::class.java)) })

        // NUEVA Lección 7
        DualLessonCard("Lección 7: Navegación y Frags", "Activities, Fragments y Datos.", 
            onXml = { context.startActivity(Intent(context, XmlFragmentsActivity::class.java)) },
            onCompose = { context.startActivity(Intent(context, ComposeNavigationActivity::class.java)) })

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun DualLessonCard(title: String, description: String, onXml: () -> Unit, onCompose: () -> Unit) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(title, fontSize = 20.sp, style = MaterialTheme.typography.titleLarge)
            Text(description, fontSize = 14.sp, modifier = Modifier.padding(bottom = 12.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                OutlinedButton(onClick = onXml) { Text("XML") }
                Button(onClick = onCompose) { Text("Compose") }
            }
        }
    }
}

@Composable
fun LessonCard(title: String, description: String, icon: ImageVector, onClick: () -> Unit, color: androidx.compose.ui.graphics.Color = MaterialTheme.colorScheme.primaryContainer) {
    Card(
        modifier = Modifier.fillMaxWidth().clickable { onClick() },
        colors = CardDefaults.cardColors(containerColor = color),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(modifier = Modifier.padding(16.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(imageVector = icon, contentDescription = null, modifier = Modifier.size(48.dp))
            Column(modifier = Modifier.padding(start = 16.dp)) {
                Text(title, fontSize = 18.sp, style = MaterialTheme.typography.titleLarge)
                Text(description, fontSize = 14.sp)
            }
        }
    }
}
