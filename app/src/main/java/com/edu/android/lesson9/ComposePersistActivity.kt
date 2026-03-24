package com.edu.android.lesson9

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class ComposePersistActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PersistScreen()
        }
    }
}

@Composable
fun PersistScreen() {
    val context = LocalContext.current
    val prefs = remember { context.getSharedPreferences("compose_prefs", Context.MODE_PRIVATE) }
    
    var savedText by remember { mutableStateOf(prefs.getString("status", "") ?: "") }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Lección 9: Persistencia y Acciones (Compose)", fontSize = 20.sp, color = MaterialTheme.colorScheme.primary)
        
        Spacer(modifier = Modifier.height(16.dp))
        
        Text("Persistencia Reactiva (SharedPreferences)", style = MaterialTheme.typography.titleSmall)
        OutlinedTextField(
            value = savedText,
            onValueChange = { savedText = it },
            label = { Text("Escribe algo para persistir...") },
            modifier = Modifier.fillMaxWidth()
        )
        
        Button(
            onClick = { 
                prefs.edit().putString("status", savedText).apply()
                Toast.makeText(context, "Persistido con éxito", Toast.LENGTH_SHORT).show()
            },
            modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
        ) {
            Text("Guardar Estado")
        }

        Spacer(modifier = Modifier.height(24.dp))
        Text("Intenciones Implícitas", style = MaterialTheme.typography.titleSmall)
        
        Row(modifier = Modifier.fillMaxWidth()) {
            Button(
                onClick = { 
                    val intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://www.poli.edu.co"))
                    context.startActivity(intent)
                },
                modifier = Modifier.weight(1f).padding(end = 4.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
            ) {
                Text("Visitar Web")
            }
            
            Button(
                onClick = { 
                    val sendIntent = Intent(Intent.ACTION_SEND).apply {
                        putExtra(Intent.EXTRA_TEXT, "Aprendiendo Compose en el Poli.")
                        type = "text/plain"
                    }
                    context.startActivity(Intent.createChooser(sendIntent, "Compartir"))
                },
                modifier = Modifier.weight(1f).padding(start = 4.dp),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.tertiary)
            ) {
                Text("Compartir")
            }
        }

        Spacer(modifier = Modifier.weight(1f))
        
        OutlinedButton(
            onClick = { (context as? android.app.Activity)?.finish() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver al Menú")
        }
    }
}
