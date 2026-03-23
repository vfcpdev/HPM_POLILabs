package com.edu.android // Define el paquete al que pertenece esta clase (estructura de carpetas)

import android.content.Intent // Importa la clase Intent, usada para transiciones entre componentes (pantallas)
import android.os.Bundle // Importa la clase Bundle, para guardar estado y pasar datos entre componentes
import android.widget.Button // Importa la vista de Botón para Android Tradicional
import androidx.appcompat.app.AppCompatActivity // Importa la clase base para Actividades compatibles con versiones previas de Android
import com.edu.android.lesson1.ComposeHelloWorldActivity // Actividad Compose Lección 1
import com.edu.android.lesson1.XmlHelloWorldActivity // Actividad XML Lección 1
import com.edu.android.lesson2.ComposeCounterActivity // Actividad Compose Lección 2
import com.edu.android.lesson2.XmlCounterActivity // Actividad XML Lección 2
import com.edu.android.lesson3.ComposeListActivity // Actividad Compose Lección 3
import com.edu.android.lesson3.XmlListActivity // Actividad XML Lección 3
import com.edu.android.lesson4.ComposeTodoActivity // Actividad Compose Lección 4
import com.edu.android.lesson4.XmlTodoActivity // Actividad XML Lección 4

// La clase hereda de AppCompatActivity, lo que la convierte en una pantalla del sistema Android
class MainActivity : AppCompatActivity() {
    
    // El método onCreate es el primer método que se llama al crearse la pantalla (Ciclo de Vida)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) // Llama al comportamiento por defecto del framework
        setContentView(R.layout.activity_main) // Asocia esta Actividad con el archivo visual XML (activity_main.xml)

        // BOTONES LECCIÓN 1
        findViewById<Button>(R.id.btnXmlHola).setOnClickListener {
            startActivity(Intent(this, XmlHelloWorldActivity::class.java))
        }
        findViewById<Button>(R.id.btnComposeHola).setOnClickListener {
            startActivity(Intent(this, ComposeHelloWorldActivity::class.java))
        }

        // BOTONES LECCIÓN 2
        findViewById<Button>(R.id.btnXmlCounter).setOnClickListener {
            startActivity(Intent(this, XmlCounterActivity::class.java))
        }
        findViewById<Button>(R.id.btnComposeCounter).setOnClickListener {
            startActivity(Intent(this, ComposeCounterActivity::class.java))
        }

        // BOTONES LECCIÓN 3 (Listas)
        findViewById<Button>(R.id.btnXmlList).setOnClickListener {
            startActivity(Intent(this, XmlListActivity::class.java))
        }
        findViewById<Button>(R.id.btnComposeList).setOnClickListener {
            startActivity(Intent(this, ComposeListActivity::class.java))
        }

        // BOTONES LECCIÓN 4 (Tareas)
        findViewById<Button>(R.id.btnXmlTodo).setOnClickListener {
            startActivity(Intent(this, XmlTodoActivity::class.java))
        }
        findViewById<Button>(R.id.btnComposeTodo).setOnClickListener {
            startActivity(Intent(this, ComposeTodoActivity::class.java))
        }
    }
}
