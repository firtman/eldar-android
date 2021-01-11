package com.eldars.transporte.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.eldars.transporte.model.NotasProvider

class NotasAdapter: RecyclerView.Adapter<NotasAdapter.NotaViewHolder>() {

    class NotaViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

    }

    override fun onBindViewHolder(holder: NotaViewHolder, position: Int) {
        val textView: TextView = holder.itemView as TextView
        textView.text = NotasProvider.getProvider().listAll()[position].titulo
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotaViewHolder {
        return NotaViewHolder(TextView(parent.context))
    }

    override fun getItemCount(): Int {
        return NotasProvider.getProvider().listAll().count()
    }
}