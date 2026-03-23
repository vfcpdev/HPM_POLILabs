# Guía Paso a Paso: Curso Práctico de Android (Tradicional vs Jetpack Compose)

¡Bienvenido a este proyecto educativo! Este proyecto está diseñado para enseñarte a desarrollar aplicaciones móviles Android desde cero, comparando en cada lección el enfoque tradicional (usando vistas XML) y el enfoque moderno (usando Jetpack Compose).

## Estructura del curso

El proyecto consta de las siguientes lecciones, implementadas de manera dual:
- **Lección 1: Hola Mundo** (Conceptos de Interfaz y Texto)
- **Lección 2: Contadores y Estado** (Manejo de Botones y actualización de UI)
- **Lección 3: Listas Dinámicas** (RecyclerView vs LazyColumn)
- **Lección 4: Aplicación Final** (Una Mini App Funcional de Tareas)

A continuación, la guía para explorar y completar cada ejercicio.

---

### Lección 1: Hola Mundo
**Objetivo**: Mostrar texto estático en pantalla.

*   **Enfoque Tradicional (XML)**
    1.  Ir al archivo `app/src/main/res/layout/activity_lesson1_xml.xml`.
    2.  Observa cómo se utiliza un `<TextView>` para declarar el texto.
    3.  Ir a `lesson1/XmlHelloWorldActivity.kt` y ver cómo el método `setContentView(R.layout...)` enlaza el layout.
*   **Enfoque Jetpack Compose**
    1.  Ir a `compose/lesson1/ComposeHelloWorldActivity.kt`.
    2.  Observar el uso de `setContent { }`.
    3.  Identificar la anotación `@Composable` en la función `HelloWorldScreen()` y el componente `Text("Hola Mundo")`.

---

### Lección 2: Estado y Eventos (El Contador)
**Objetivo**: Responder a clicks de botones y actualizar el texto en tiempo real.

*   **Enfoque Tradicional (XML)**
    1.  Revisa el layout `activity_lesson2_xml.xml` (debe tener un `TextView` y un `Button`).
    2.  En `XmlCounterActivity.kt`, fíjate en cómo se usa `findViewById` (o ViewBinding si se prefiere) para atrapar el botón y asignarle un `setOnClickListener`.
    3.  Observa cómo se actualiza manualmente el texto del `TextView`.
*   **Enfoque Jetpack Compose**
    1.  Ve a `ComposeCounterActivity.kt`.
    2.  Estudia cómo se declara el estado usando `val count = remember { mutableStateOf(0) }`.
    3.  Mira cómo dentro del botón (componente `Button(onClick = { count.value++ })`) actualizamos la variable y, **automáticamente**, la UI se redibuja (recomposición).

---

### Lección 3: Listas Dinámicas
**Objetivo**: Mostrar un gran número de elementos en la pantalla.

*   **Enfoque Tradicional (XML)**
    1.  Es el más laborioso. Estudia el layout que contiene el `RecyclerView`.
    2.  Crea un nuevo layout XML para el elemento individual (`item_lista.xml`).
    3.  Abre `XmlListActivity.kt` y analiza la clase `Adapter` asociada, cómo se sobrescriben los métodos `onCreateViewHolder`, `onBindViewHolder` y `getItemCount`.
*   **Enfoque Jetpack Compose**
    1.  Ve a `ComposeListActivity.kt`.
    2.  Examina el componente `LazyColumn { items(miLista) { item -> ... } }`.
    3.  Nota lo directo que es sin necesidad de Adaptadores ni ViewHolders explícitos.

---

### Lección 4: Aplicación Mínima Funcional (Lista de Tareas)
**Objetivo**: Crear una pantalla donde el usuario escriba una tarea, la guarde presionando un botón, y la agregue a una lista junto con las demás.

*   **Paso a paso para ambos enfoques**:
    *   **Tradicional**: Necesitaremos un `EditText`, un `Button` y un `RecyclerView` en un mismo archivo XML. Cuando el botón se pulsa, obtener el texto del EditText, agregarlo a la lista de datos del Adaptador e invocar `notifyItemInserted()`.
    *   **Compose**: Necesitaremos un estado para el texto escrito (`TextFieldValue` o `String`) y un estado de lista (`mutableStateListOf()`). Consumir un input con un `OutlinedTextField`, añadirlo a la lista de estado al pulsar el `Button` y que `LazyColumn` se encargue de mostrarlo.

---

## ¿Cómo ejecutar el proyecto?
1. Abre este directorio raíz en **Android Studio**.
2. Una vez que termine la sincronización (Gradle Sync), ve al archivo `MainActivity.kt`.
3. Conecta tu dispositivo físico por USB o inicia un emulador.
4. Presiona el botón verde de "Run/Play" en la barra superior.
5. El menú principal de la app te dejará saltar a las diferentes lecciones.
