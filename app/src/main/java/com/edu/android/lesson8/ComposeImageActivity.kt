package com.edu.android.lesson8

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest

class ComposeImageActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ImageScreen()
        }
    }
}

@Composable
fun ImageScreen() {
    val context = LocalContext.current
    val imageUrl = "https://www.poli.edu.co/sites/default/files/logo-poli-footer.png"

    Column(
        modifier = Modifier.fillMaxSize().padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text("Lección 8: Imágenes en Compose", fontSize = 24.sp, color = Color(0xFF1FB2DE))
        Text("Uso de la librería Coil (2.5.0)", fontSize = 14.sp, color = Color.Gray, modifier = Modifier.padding(bottom = 24.dp))

        // Imagen asíncrona usando Coil
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageUrl)
                .crossfade(true)
                .build(),
            contentDescription = "Imagen Remota",
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .background(Color.LightGray),
            contentScale = ContentScale.Fit
        )

        Spacer(modifier = Modifier.height(32.dp))

        // Demo de paleta secundaria en Compose
        Row(horizontalArrangement = Arrangement.SpaceEvenly, modifier = Modifier.fillMaxWidth()) {
            Box(modifier = Modifier.size(50.dp).background(Color(0xFFFBAF17))) // Naranja
            Box(modifier = Modifier.size(50.dp).background(Color(0xFFA6CE38))) // Verde
            Box(modifier = Modifier.size(50.dp).background(Color(0xFFEC0677))) // Magenta
            Box(modifier = Modifier.size(50.dp).background(Color(0xFF15BECE))) // Cian
        }

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = { (context as? Activity)?.finish() },
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF0F385A))
        ) {
            Text("Volver al Menú", color = Color.White)
        }
    }
}
