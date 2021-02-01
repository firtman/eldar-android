package com.eldars.transporte.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.eldars.transporte.R
import com.eldars.transporte.model.Nota
import com.eldars.transporte.model.NotasProvider


class NotasDetailsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView =  inflater.inflate(R.layout.fragment_notas_details, container, false)

        //TODO Saber qué nota es
        val posicion = arguments?.getInt("posicion")
        if (posicion == null) {
            //TODO Manejar error

        }
        var nota: Nota? = NotasProvider.getProvider().get(posicion!!)
        rootView.findViewById<TextView>(R.id.txtNotaTitulo).text = nota?.titulo
        rootView.findViewById<TextView>(R.id.txtNotaTexto).text = nota?.texto
        rootView.findViewById<Button>(R.id.btnEliminar).setOnClickListener {
            AlertDialog.Builder(activity).setTitle("Eliminación de Nota")
                .setMessage("Se perderá la nota para siempre ¿Está seguro/a?")
                .setPositiveButton("Si") { _, _ ->
                    //TODO Implementar el eliminar en provider
                    findNavController().navigateUp()
                }
                .setNegativeButton("No", null)
                .show()
        }

        return rootView
    }


}