package com.edu.android // Define el paquete al que pertenece esta clase (estructura de carpetas)

import android.content.Intent // Importa la clase Intent, usada para transiciones entre componentes (pantallas)
import android.os.Bundle // Importa la clase Bundle, para guardar estado y pasar datos entre componentes
import android.widget.Button // Importa la vista de Botón para Android Tradicional
import androidx.appcompat.app.AppCompatActivity // Importa la clase base para Actividades compatibles con versiones previas de Android
import com.edu.android.lesson1.ComposeHelloWorldActivity // Actividad Compose Lección 1
import com.edu.android.lesson1.XmlHelloWorldActivity // Actividad XML Lección 1
import com.edu.android.lesson2.ComposeCounterActivity // Actividad Compose Lección 2
import com.edu.android.lesson2.XmlCounterActivity // Actividad XML Lección 2

// La clase hereda de AppCompatActivity, lo que la convierte en una pantalla del sistema Android
class MainActivity : AppCompatActivity() {
    
    // El método onCreate es el primer método que se llama al crearse la pantalla (Ciclo de Vida)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llama al comportamiento por defecto del framework
        setContentView(R.layout.activity_main) // Asocia esta Actividad con el archivo visual XML (activity_main.xml)

        // Busca el botón "btnXmlHola" en la vista y configura la acción que ocurrirá al darle clic
        findViewById<Button>(R.id.btnXmlHola).setOnClickListener {
            // Un Intent describe la intención de hacer algo; aquí: "Ir a XmlHelloWorldActivity"
            startActivity(Intent(this, XmlHelloWorldActivity::class.java)) // Lanza la actividad deseada
        }

        // Busca el botón de Compose de Hola Mundo
        findViewById<Button>(R.id.btnComposeHola).setOnClickListener {
            startActivity(Intent(this, ComposeHelloWorldActivity::class.java)) // Lanza la actividad en modo Jetpack Compose
        }

        // Busca el botón de XML del Contador
        findViewById<Button>(R.id.btnXmlCounter).setOnClickListener {
            startActivity(Intent(this, XmlCounterActivity::class.java)) // Lanza el componente Contador Tradicional
        }

        // Busca el botón de Compose del Contador
        findViewById<Button>(R.id.btnComposeCounter).setOnClickListener {
            startActivity(Intent(this, ComposeCounterActivity::class.java)) // Lanza el componente Contador Jetpack Compose
        }
    }
}
