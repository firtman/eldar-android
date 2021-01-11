package com.eldars.transporte.model

class NotasProvider {
    companion object {
        private val _instance = NotasProvider()
        fun getProvider(): NotasProvider {
            return _instance
        }
    }

    private val notas = mutableListOf<Nota>(
        Nota("Teléfono", "324234234234"),
        Nota("Dirección", "dfsdfsdfs sdf sdsf")
    )

    fun addNota(nota: Nota) {
        notas.add(nota)
    }
    fun listAll(): MutableList<Nota> {
        return notas
    }

}