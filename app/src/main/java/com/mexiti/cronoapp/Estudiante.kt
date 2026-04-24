package com.mexiti.cronoapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "estudiantes")
data class Estudiante(

    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val nombre: String,
    val edad: Int,
    val promedio: Float,
    val activo: Boolean,

    val carrera: String,
    val semestre: Int
)