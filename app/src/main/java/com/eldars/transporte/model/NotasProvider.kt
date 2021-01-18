package com.eldars.transporte.model

class NotasProvider {
    companion object {
        private val _instance = NotasProvider()
        fun getProvider(): NotasProvider {
            return _instance
        }
    }

    private val listeners = mutableListOf<()->Unit>()
    fun registerListener(listener: ()->Unit) {
        listeners.add(listener)
    }

    private val notas = mutableListOf<Nota>(
        Nota("Teléfono", "324234234234"),
        Nota("Dirección", "dfsdfsdfs sdf sdsf"),
    )

    fun addNota(nota: Nota) {
        notas.add(nota)
        listeners.forEach { it.invoke() }
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