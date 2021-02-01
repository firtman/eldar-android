package com.eldars.transporte.model

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Nota::class), version = 1)
abstract class AppDatabase: RoomDatabase() {
    // Una función por cada DAO, o sea, por cada entity (o tabla)
    abstract fun notasDao(): NotasDao
}