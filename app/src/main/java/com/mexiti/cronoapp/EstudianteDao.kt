package com.mexiti.cronoapp

import androidx.room.*

@Dao
interface EstudianteDao {

    @Insert
    suspend fun insertarTodos(estudiantes: List<Estudiante>)

    @Query("SELECT * FROM estudiantes")
    suspend fun obtenerTodos(): List<Estudiante>

    @Query("SELECT * FROM estudiantes WHERE id = :id")
    suspend fun obtenerPorId(id: Int): Estudiante?

    @Query("SELECT * FROM estudiantes WHERE nombre = :nombre LIMIT 1")
    suspend fun obtenerPorNombre(nombre: String): Estudiante?

    @Update
    suspend fun actualizar(estudiante: Estudiante)
}