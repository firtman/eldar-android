package com.eldars.transporte.model

import androidx.room.Room
import com.eldars.transporte.App

class NotasProvider {
    companion object {
        private val _instance = NotasProvider()
        fun getProvider(): NotasProvider {
            return _instance
        }
    }

    private var notas = mutableListOf<Nota>()

    private var db: AppDatabase = Room.databaseBuilder(
        App.context,
        AppDatabase::class.java, "transporte"
    ).allowMainThreadQueries().build()

    init {
        notas = db.notasDao().getAll().toMutableList()
    }


    private val listeners = mutableListOf<()->Unit>()
    fun registerListener(listener: ()->Unit) {
        listeners.add(listener)
    }


    fun addNota(nota: Nota) {
        notas.add(nota)
        listeners.forEach { it.invoke() }
        // Actualizar la BD
        db.notasDao().insert(nota)
    }
    fun listAll(): MutableList<Nota> {
        return notas
    }
    fun get(i: Int) : Nota? {
        if (i>=0) {
            return notas[i]
        } else {
            return null
        }
    }

}