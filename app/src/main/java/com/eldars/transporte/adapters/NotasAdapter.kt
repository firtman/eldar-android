package com.eldars.transporte.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eldars.transporte.R
import com.eldars.transporte.model.Nota
import com.eldars.transporte.model.NotasProvider

class NotasAdapter: RecyclerView.Adapter<NotasAdapter.NotaViewHolder>() {

    class NotaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind(nota: Nota) {
            val txtTitulo = itemView.findViewById<TextView>(R.id.item_nota_titulo)
            txtTitulo.text = nota.titulo
        }
    }

    // enlaza los datos en un viewholder a partir de una posición
    override fun onBindViewHolder(holder: NotaViewHolder, position: Int) {
        val nota = NotasProvider.getProvider().get(position)
        nota?.let {
            holder.bind(nota)

            if (position % 2 == 0) {
                holder.itemView.setBackgroundColor(Color.YELLOW)
            } else {
                holder.itemView.setBackgroundColor(Color.WHITE)
            }

        }
//        if (nota != null) {
//            holder.bind(nota!!)
//        }
    }

    // La recyclerview nos pide un viewholder vacío
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotaViewHolder {
        val inflador = LayoutInflater.from(parent.context)
        val itemNota = inflador.inflate(R.layout.item_nota, parent, false)
        return NotaViewHolder(itemNota)
    }

    override fun getItemCount(): Int {
        return NotasProvider.getProvider().listAll().count()
    }
}