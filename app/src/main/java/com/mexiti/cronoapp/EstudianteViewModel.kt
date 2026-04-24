package com.mexiti.cronoapp

import android.app.Application
import androidx.compose.runtime.*
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.mexiti.cronoapp.AppDatabase
import com.mexiti.cronoapp.Estudiante
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EstudianteViewModel(application: Application) : AndroidViewModel(application) {

    private val dao = AppDatabase.getDatabase(application).estudianteDao()

    private val _estudiante = mutableStateOf<Estudiante?>(null)
    val estudiante: State<Estudiante?> = _estudiante

    var mensaje by mutableStateOf("")

    fun insertarEstudiantes() {
        viewModelScope.launch(Dispatchers.IO) {

            val lista = dao.obtenerTodos()

            if (lista.isEmpty()) {
                val estudiantes = listOf(
                    Estudiante(nombre = "Ana", edad = 20, promedio = 9.5f, activo = true, carrera = "Sistemas", semestre = 3),
                    Estudiante(nombre = "Luis", edad = 22, promedio = 8.7f, activo = true, carrera = "Industrial", semestre = 5),
                    Estudiante(nombre = "Carlos", edad = 21, promedio = 7.9f, activo = false, carrera = "Civil", semestre = 4),
                    Estudiante(nombre = "Sofía", edad = 19, promedio = 9.8f, activo = true, carrera = "Software", semestre = 2),
                    Estudiante(nombre = "Marta", edad = 23, promedio = 8.2f, activo = false, carrera = "Administración", semestre = 6)
                )

                dao.insertarTodos(estudiantes)
                mensaje = "Datos insertados correctamente"
            } else {
                mensaje = "Los datos ya existen"
            }
        }
    }

    fun actualizarEstudiantes() {
        viewModelScope.launch(Dispatchers.IO) {

            val lista = dao.obtenerTodos()

            if (lista.size >= 2) {
                val e1 = lista[0].copy(promedio = 10.0f)
                val e2 = lista[1].copy(activo = false)

                dao.actualizar(e1)
                dao.actualizar(e2)

                mensaje = "Estudiantes actualizados"
            } else {
                mensaje = "No hay datos para actualizar"
            }
        }
    }

    fun buscarPorId(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            _estudiante.value = dao.obtenerPorId(id)
        }
    }

    fun buscarPorNombre(nombre: String) {
        viewModelScope.launch(Dispatchers.IO) {
            _estudiante.value = dao.obtenerPorNombre(nombre)
        }
    }
}