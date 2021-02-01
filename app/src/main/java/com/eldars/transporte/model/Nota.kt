package com.eldars.transporte.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "NOTAS")
data class Nota(  // Propiedades en el constructor - obligatorias
    val titulo: String,
    @ColumnInfo(name="nota_texto") var texto: String
)
{
    // Propiedades no obligatorias
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}