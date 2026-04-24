package com.mexiti.cronoapp

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mexiti.cronoapp.AppDatabase
import com.mexiti.cronoapp.Estudiante
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EstudianteViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = AppDatabase.getDatabase(application).estudianteDao()

    // Insertar 5 estudiantes
    fun insertarEstudiantes() {
        viewModelScope.launch(Dispatchers.IO) {

            val estudiantes = listOf(
                Estudiante(nombre = "Ana", edad = 20, promedio = 9.5f, activo = true, carrera = "Sistemas", semestre = 3),
                Estudiante(nombre = "Luis", edad = 22, promedio = 8.7f, activo = true, carrera = "Industrial", semestre = 5),
                Estudiante(nombre = "Carlos", edad = 21, promedio = 7.9f, activo = false, carrera = "Civil", semestre = 4),
                Estudiante(nombre = "Sofía", edad = 19, promedio = 9.8f, activo = true, carrera = "Software", semestre = 2),
                Estudiante(nombre = "Marta", edad = 23, promedio = 8.2f, activo = false, carrera = "Administración", semestre = 6)
            )

            dao.insertarTodos(estudiantes)
        }
    }

    fun actualizarEstudiantes() {
        viewModelScope.launch(Dispatchers.IO) {

            val lista = dao.obtenerTodos()

            if (lista.size >= 2) {

                val actualizado1 = lista[0].copy(promedio = 10.0f)
                val actualizado2 = lista[1].copy(activo = false)

                dao.actualizar(actualizado1)
                dao.actualizar(actualizado2)
            }
        }
    }
}