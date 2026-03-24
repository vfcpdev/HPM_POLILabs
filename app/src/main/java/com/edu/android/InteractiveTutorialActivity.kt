package com.edu.android

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
import androidx.compose.ui.text.style.TextAlign

class InteractiveTutorialActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TutorialScreen()
        }
    }
}

@Composable
fun TutorialScreen() {
    val tutorialPages = listOf(
        TutorialPageData("¡Bienvenido!", "Este curso te enseñará la diferencia entre el desarrollo nativo con XML y el enfoque moderno con Jetpack Compose."),
        TutorialPageData("Lección 1: Hola Mundo", "En XML usamos layouts estáticos. En Compose usamos funciones que describen la UI."),
        TutorialPageData("Lección 2: Estado", "Aprenderás a usar 'remember' y 'mutableStateOf' para que tu app responda a cambios."),
        TutorialPageData("Lección 3: Listas", "RecyclerView (XML) requiere adaptadores complejos, mientras que LazyColumn (Compose) es increíblemente simple."),
        TutorialPageData("Lección 5: Controles", "Usa Switch, Checkbox y RadioGroups para interactuar con el usuario."),
        TutorialPageData("¡Listo!", "Explora los ejercicios y compara los dos mundos.")
    )

    var currentPage by remember { mutableStateOf(0) }
    val context = LocalContext.current

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Column(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(tutorialPages[currentPage].title, fontSize = 28.sp, color = MaterialTheme.colorScheme.primary, textAlign = TextAlign.Center)
            Spacer(modifier = Modifier.height(24.dp))
            Text(tutorialPages[currentPage].description, fontSize = 18.sp, textAlign = TextAlign.Center)
        }

        Row(
            modifier = Modifier.fillMaxWidth().padding(top = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            TextButton(onClick = { (context as? Activity)?.finish() }) {
                Text("Cerrar")
            }
            
            Button(onClick = { 
                if (currentPage == tutorialPages.size - 1) {
                    (context as? Activity)?.finish()
                } else {
                    currentPage++
                }
            }) {
                Text(if (currentPage == tutorialPages.size - 1) "Empezar" else "Siguiente")
            }
        }
    }
}

data class TutorialPageData(val title: String, val description: String)
