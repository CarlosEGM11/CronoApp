package com.mexiti.cronoapp

import androidx.room.*

@Dao
interface EstudianteDao {

    @Insert
    suspend fun insertar(estudiante: Estudiante)

    @Insert
    suspend fun insertarTodos(estudiantes: List<Estudiante>)

    @Query("SELECT * FROM estudiantes")
    suspend fun obtenerTodos(): List<Estudiante>

    @Query("SELECT * FROM estudiantes WHERE id = :id")
    suspend fun obtenerPorId(id: Int): Estudiante?

    @Update
    suspend fun actualizar(estudiante: Estudiante)

    @Delete
    suspend fun eliminar(estudiante: Estudiante)
}