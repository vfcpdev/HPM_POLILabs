package com.edu.android.lesson6

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight

class ComposeLayoutsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LayoutsScreen()
        }
    }
}

@Composable
fun LayoutsScreen() {
    val context = LocalContext.current
    
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Lección 6: Layouts en Compose", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(bottom = 16.dp))

        // 1. Column and Row (LinearLayout equivalent)
        Text("1. Column (Vertical) and Row (Horizontal)", fontWeight = FontWeight.Bold)
        Row(
            modifier = Modifier.fillMaxWidth().background(Color.LightGray).padding(8.dp),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Button(onClick = {}) { Text("Botón 1") }
            Button(onClick = {}) { Text("Botón 2") }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 2. Box (FrameLayout equivalent)
        Text("2. Box (Contenedor Flexible y Superposiciones)", fontWeight = FontWeight.Bold)
        Box(
            modifier = Modifier.size(150.dp, 100.dp).background(Color.Gray),
            contentAlignment = Alignment.Center
        ) {
            Box(modifier = Modifier.size(80.dp).background(Color.Red))
            Text("Centro", color = Color.White)
            Text("Top-Start", modifier = Modifier.align(Alignment.TopStart).padding(4.dp), fontSize = 10.sp)
        }

        Spacer(modifier = Modifier.height(24.dp))

        // 3. Grid (LazyVerticalGrid equivalent or simple)
        Text("3. Layout Flexible con Pesos (Weight)", fontWeight = FontWeight.Bold)
        Row(modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.weight(1f).height(50.dp).background(Color.Cyan).padding(8.dp)) { Text("W:1") }
            Box(modifier = Modifier.weight(2f).height(50.dp).background(Color.Magenta).padding(8.dp)) { Text("W:2") }
            Box(modifier = Modifier.weight(1f).height(50.dp).background(Color.Yellow).padding(8.dp)) { Text("W:1") }
        }

        Spacer(modifier = Modifier.height(48.dp))

        Button(
            onClick = { (context as? Activity)?.finish() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver al Menú")
        }
    }
}
