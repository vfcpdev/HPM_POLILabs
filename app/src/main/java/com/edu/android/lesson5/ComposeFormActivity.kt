package com.edu.android.lesson5

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ComposeFormActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FormScreen()
        }
    }
}

@Composable
fun FormScreen() {
    val context = LocalContext.current
    var terms by remember { mutableStateOf(false) }
    var darkMode by remember { mutableStateOf(false) }
    var selectedGender by remember { mutableStateOf("Desconocido") }
    var resultText by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.Start
    ) {
        Text("Lección 5: Controles Compose", fontSize = 24.sp, modifier = Modifier.padding(bottom = 16.dp))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = terms, onCheckedChange = { terms = it })
            Text("Aceptar términos y condiciones")
        }

        Spacer(modifier = Modifier.height(16.dp))
        
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = darkMode, onCheckedChange = { darkMode = it })
            Text("Modo Oscuro Simulado", modifier = Modifier.padding(start = 16.dp))
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text("Elige Género:")
        
        val genders = listOf("Masculino", "Femenino", "Otro")
        genders.forEach { gender ->
            Row(verticalAlignment = Alignment.CenterVertically) {
                RadioButton(
                    selected = (gender == selectedGender),
                    onClick = { selectedGender = gender }
                )
                Text(gender)
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                resultText = "Resultados:\n" +
                        "Términos: ${if (terms) "Aceptado" else "No aceptado"}\n" +
                        "Modo Oscuro: ${if (darkMode) "Activado" else "Desactivado"}\n" +
                        "Género: $selectedGender"
                Toast.makeText(context, "Datos Procesados", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Enviar Formulario")
        }

        if (resultText.isNotEmpty()) {
            Text(text = resultText, modifier = Modifier.padding(top = 16.dp))
        }

        Spacer(modifier = Modifier.height(24.dp))

        OutlinedButton(
            onClick = { (context as? Activity)?.finish() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver al Menú")
        }
    }
}
