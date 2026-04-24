package com.mexiti.cronoapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.mexiti.cronoapp.EstudianteViewModel

@Composable
fun PantallaPrincipal(estudianteVM: EstudianteViewModel) {

    Column(modifier = Modifier.fillMaxSize()) {

        Button(onClick = {
            estudianteVM.insertarEstudiantes()
        }) {
            Text("Insertar 5 estudiantes")
        }

        Button(onClick = {
            estudianteVM.actualizarEstudiantes()
        }) {
            Text("Actualizar 2 estudiantes")
        }
    }
}