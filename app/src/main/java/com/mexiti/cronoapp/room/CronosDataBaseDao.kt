package com.mexiti.cronoapp.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.mexiti.cronoapp.model.Cronos
import kotlinx.coroutines.flow.Flow


@Dao  //Data Access Observer
interface CronosDatabaseDao {
    //CRUD:operaciones de SQL
    @Query("SELECT * FROM cronos")
    fun getCronos(): Flow<List<Cronos>> //Flow permite manejar corrutinas con colecciones de datos
    @Query("SELECT * FROM cronos Where id=:id")
    fun getCronosById(id:Long): Flow<Cronos>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    //Si un dato ya existe, entonces se reemplaza para evitar errores de ejecución
    suspend fun insert(crono:Cronos)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(crono:Cronos)
    @Delete
    suspend fun delete(crono:Cronos)
}