package com.mexiti.cronoapp.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mexiti.cronoapp.model.Cronos


@Database(entities = [Cronos::class], version = 1, exportSchema = false)
//"Version" indica la versión de tu trabajo, mientras que "exportSchema" indica que se va a trabajar
// con una base de datos local
abstract class CronosDataBase:RoomDatabase() {
    abstract fun cronosDao():CronosDatabaseDao
}