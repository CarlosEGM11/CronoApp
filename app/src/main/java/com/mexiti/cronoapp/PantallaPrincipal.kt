package com.mexiti.cronoapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mexiti.cronoapp.EstudianteViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PantallaPrincipal(vm: EstudianteViewModel) {

    var id by remember { mutableStateOf("") }
    var nombre by remember { mutableStateOf("") }

    val estudiante = vm.estudiante.value
    val mensaje = vm.mensaje

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Gestión de Estudiantes") }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp)
                .fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            // 🔹 Botones principales
            Button(onClick = { vm.insertarEstudiantes() }, modifier = Modifier.fillMaxWidth()) {
                Text("Insertar estudiantes")
            }

            Button(onClick = { vm.actualizarEstudiantes() }, modifier = Modifier.fillMaxWidth()) {
                Text("Actualizar estudiantes")
            }

            Divider()

            Text("Buscar estudiante", style = MaterialTheme.typography.titleMedium)

            // 🔹 Buscar por ID
            OutlinedTextField(
                value = id,
                onValueChange = { id = it },
                label = { Text("ID") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(onClick = {
                id.toIntOrNull()?.let { vm.buscarPorId(it) }
            }, modifier = Modifier.fillMaxWidth()) {
                Text("Buscar por ID")
            }

            // 🔹 Buscar por nombre
            OutlinedTextField(
                value = nombre,
                onValueChange = { nombre = it },
                label = { Text("Nombre") },
                modifier = Modifier.fillMaxWidth()
            )

            Button(onClick = {
                if (nombre.isNotEmpty()) vm.buscarPorNombre(nombre)
            }, modifier = Modifier.fillMaxWidth()) {
                Text("Buscar por nombre")
            }

            Divider()

            // 🔹 Resultado
            estudiante?.let {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text("Nombre: ${it.nombre}")
                        Text("Edad: ${it.edad}")
                        Text("Carrera: ${it.carrera}")
                        Text("Promedio: ${it.promedio}")
                    }
                }
            }

            // 🔹 Mensaje
            if (mensaje.isNotEmpty()) {
                Text(
                    text = mensaje,
                    color = MaterialTheme.colorScheme.primary
                )
            }
        }
    }
}