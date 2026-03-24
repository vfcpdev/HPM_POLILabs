package com.edu.android.lesson7

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ComposeNavigationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NavigationApp()
        }
    }
}

@Composable
fun NavigationApp() {
    // 1. Manejo manual de rutas simple (Sin depender de librerías externas pesadas si no es necesario)
    var currentRoute by remember { mutableStateOf("home") }
    var sentMessage by remember { mutableStateOf("") }
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        when (currentRoute) {
            "home" -> {
                Text("Pantalla 1 (Home)", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))
                OutlinedTextField(
                    value = sentMessage,
                    onValueChange = { sentMessage = it },
                    label = { Text("Escribe algo para pasar...") },
                    modifier = Modifier.fillMaxWidth()
                )
                Button(
                    onClick = { currentRoute = "details" },
                    modifier = Modifier.padding(top = 16.dp).fillMaxWidth()
                ) {
                    Text("Ir a Pantalla 2")
                }
            }
            "details" -> {
                Text("Pantalla 2 (Detalles)", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))
                Text("Dato recibido: $sentMessage", color = MaterialTheme.colorScheme.primary)
                Button(
                    onClick = { currentRoute = "home" },
                    modifier = Modifier.padding(top = 24.dp).fillMaxWidth()
                ) {
                    Text("Cerrar y Regresar")
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        OutlinedButton(
            onClick = { (context as? Activity)?.finish() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver al Menú")
        }
    }
}
