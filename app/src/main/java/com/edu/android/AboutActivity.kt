package com.edu.android

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class AboutActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AboutScreen()
        }
    }
}

@Composable
fun AboutScreen() {
    val context = LocalContext.current
    val pNavy = Color(0xFF0F385A)
    val pBlue = Color(0xFF1FB2DE)
    val sOrange = Color(0xFFFBAF17)

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Card(
            modifier = Modifier.fillMaxWidth().padding(bottom = 24.dp),
            colors = CardDefaults.cardColors(containerColor = pNavy),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp)
        ) {
            Column(modifier = Modifier.padding(24.dp), horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Autor del Proyecto", color = Color.White, fontSize = 14.sp)
                Text("Ing. Mg. Víctor Castro", color = pBlue, fontSize = 24.sp, fontWeight = FontWeight.Bold)
                Text("vfcastro@poligran.edu.co", color = Color.White, fontSize = 16.sp)
                
                Spacer(modifier = Modifier.height(24.dp))
                
                Text("Politécnico Grancolombiano", color = sOrange, fontSize = 14.sp)
                Text("Herramientas de Programación Móvil", color = Color.White, fontSize = 14.sp)
                Text("Año 2026", color = Color.Gray, fontSize = 12.sp)
            }
        }

        Button(
            onClick = { (context as? Activity)?.finish() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = pNavy)
        ) {
            Text("Cerrar")
        }
    }
}
