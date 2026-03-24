package com.edu.android

import android.os.Bundle
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
import androidx.compose.foundation.background
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.graphics.Color
import com.edu.android.lesson1.*
import com.edu.android.lesson2.*
import com.edu.android.lesson3.*
import com.edu.android.lesson4.*
import com.edu.android.lesson5.*
import com.edu.android.lesson6.*
import com.edu.android.lesson7.*
import com.edu.android.lesson8.*
import com.edu.android.lesson9.*

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
    
    // Paleta de colores aplicada
    val pBlue = Color(0xFF1FB2DE)
    val pNavy = Color(0xFF0F385A)
    val sOrange = Color(0xFFFBAF17)
    val sGreen = Color(0xFFA6CE38)
    val sMagenta = Color(0xFFEC0677)
    val sCyan = Color(0xFF15BECE)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Encabezado Moderno con Botón de Info
        Row(
            modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text("Android EduProject", fontSize = 32.sp, color = pNavy, fontWeight = FontWeight.Bold)
                Text("Herramientas de programación Móvil", fontSize = 16.sp, color = pBlue, fontWeight = FontWeight.Bold)
            }
            
            IconButton(
                onClick = { context.startActivity(Intent(context, AboutActivity::class.java)) },
                modifier = Modifier.size(48.dp).background(pNavy.copy(alpha = 0.1f), shape = MaterialTheme.shapes.medium)
            ) {
                Icon(Icons.Default.Info, contentDescription = "Acerca de", tint = pNavy)
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Botón Tutorial Interactivo y Explicación de Código
        Row(modifier = Modifier.fillMaxWidth().padding(bottom = 16.dp)) {
            Card(
                modifier = Modifier.weight(1f).height(100.dp).clickable { 
                    context.startActivity(Intent(context, InteractiveTutorialActivity::class.java)) 
                },
                colors = CardDefaults.cardColors(containerColor = pBlue.copy(alpha = 0.15f))
            ) {
                Column(modifier = Modifier.fillMaxSize().padding(12.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Default.Info, contentDescription = null, tint = pNavy)
                    Text("Tutorial", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                }
            }
            
            Spacer(modifier = Modifier.width(16.dp))

            Card(
                modifier = Modifier.weight(1f).height(100.dp).clickable { 
                    context.startActivity(Intent(context, CodeExplanationActivity::class.java)) 
                },
                colors = CardDefaults.cardColors(containerColor = sOrange.copy(alpha = 0.15f))
            ) {
                Column(modifier = Modifier.fillMaxSize().padding(12.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                    Icon(Icons.Default.List, contentDescription = null, tint = sOrange)
                    Text("Explicación", fontSize = 14.sp, fontWeight = FontWeight.Bold)
                }
            }
        }

        Text("Lecciones del Curso", fontSize = 18.sp, color = pNavy, modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp), fontWeight = FontWeight.Bold)

        // Lección 1 a 4 Simplificadas en lista
        DualLessonCard("L1: Hola Mundo", "Textos básicos.", 
            onXml = { context.startActivity(Intent(context, XmlHelloWorldActivity::class.java)) },
            onCompose = { context.startActivity(Intent(context, ComposeHelloWorldActivity::class.java)) },
            accentColor = sGreen)

        DualLessonCard("L2: Contador (Estado)", "Clicks y MutableState.", 
            onXml = { context.startActivity(Intent(context, XmlCounterActivity::class.java)) },
            onCompose = { context.startActivity(Intent(context, ComposeCounterActivity::class.java)) },
            accentColor = sOrange)

        DualLessonCard("L3: Listas Dinámicas", "Recycler vs LazyColumn.", 
            onXml = { context.startActivity(Intent(context, XmlListActivity::class.java)) },
            onCompose = { context.startActivity(Intent(context, ComposeListActivity::class.java)) },
            accentColor = sMagenta)

        DualLessonCard("L4: Gestión Tareas", "To-Do integrando flujos.", 
            onXml = { context.startActivity(Intent(context, XmlTodoActivity::class.java)) },
            onCompose = { context.startActivity(Intent(context, ComposeTodoActivity::class.java)) },
            accentColor = sCyan)

        DualLessonCard("L5: Controles Form.", "Checkbox, Switch, Radios.", 
            onXml = { context.startActivity(Intent(context, XmlFormActivity::class.java)) },
            onCompose = { context.startActivity(Intent(context, ComposeFormActivity::class.java)) },
            accentColor = pBlue)

        DualLessonCard("L6: Arquitectura Layouts", "Constraint, Linear, Frame.", 
            onXml = { context.startActivity(Intent(context, XmlLayoutsActivity::class.java)) },
            onCompose = { context.startActivity(Intent(context, ComposeLayoutsActivity::class.java)) },
            accentColor = sGreen)

        DualLessonCard("L7: Navegación/Frags", "Activities vs Navigation.", 
            onXml = { context.startActivity(Intent(context, XmlFragmentsActivity::class.java)) },
            onCompose = { context.startActivity(Intent(context, ComposeNavigationActivity::class.java)) },
            accentColor = sMagenta)

        DualLessonCard("L8: Carga de Imágenes", "Glide (XML) vs Coil (Compose).", 
            onXml = { context.startActivity(Intent(context, XmlImageActivity::class.java)) },
            onCompose = { context.startActivity(Intent(context, ComposeImageActivity::class.java)) },
            accentColor = sCyan)

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun DualLessonCard(title: String, description: String, onXml: () -> Unit, onCompose: () -> Unit, accentColor: Color = Color(0xFF1FB2DE)) {
    Card(
        modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Box(modifier = Modifier.fillMaxWidth()) {
                Text(title, fontSize = 18.sp, fontWeight = androidx.compose.ui.text.font.FontWeight.Bold, color = Color(0xFF0F385A))
                Box(modifier = Modifier.size(20.dp, 4.dp).background(accentColor).align(Alignment.CenterEnd))
            }
            Text(description, fontSize = 12.sp, color = Color.Gray, modifier = Modifier.padding(bottom = 8.dp))
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly) {
                OutlinedButton(onClick = onXml, modifier = Modifier.weight(1f).padding(end = 4.dp)) { Text("XML", fontSize = 12.sp) }
                Button(onClick = onCompose, modifier = Modifier.weight(1f).padding(start = 4.dp), colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF1FB2DE))) { Text("Compose", fontSize = 12.sp) }
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
