package com.eldars.transporte.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.navigation.fragment.findNavController
import com.eldars.transporte.R
import com.eldars.transporte.model.Nota
import com.eldars.transporte.model.NotasProvider

class NotasAddFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_notas_add, container, false)

        rootView.findViewById<Button>(R.id.btnEliminar).setOnClickListener {
            val titulo = rootView.findViewById<EditText>(R.id.txtNotaTitulo).text.toString()
            val texto = rootView.findViewById<EditText>(R.id.txtNotaTexto).text.toString()
            //TODO: Validación
            NotasProvider.getProvider().addNota(Nota(titulo, texto))
            findNavController().navigateUp()
        }


        return rootView
    }



}