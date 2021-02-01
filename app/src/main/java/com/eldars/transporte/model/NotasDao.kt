package com.eldars.transporte.model

import androidx.room.*

@Dao
interface NotasDao {

    @Query("SELECT * FROM NOTAS")
    fun getAll(): List<Nota>

    @Query("SELECT * FROM NOTAS WHERE id = :notaId LIMIT 1")
    fun getById(notaId: Int): Nota

    @Query("DELETE FROM NOTAS")
    fun deleteAll()

    @Insert
    fun insert(vararg nota: Nota)

    @Delete
    fun delete(nota: Nota)

    @Update
    fun update(nota: Nota)

}