package com.eldars.transporte.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.eldars.transporte.R
import com.eldars.transporte.adapters.NotasAdapter
import com.eldars.transporte.model.NotasProvider

class NotasListFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_notas_list, container, false)

        // Manual
//        rootView.findViewById<Button>(R.id.btnAgregarNota).setOnClickListener {
//            findNavController().navigate(R.id.action_notasListFragment_to_notasAddFragment)
//        }

        // Automática
        rootView.findViewById<Button>(R.id.btnAgregarNota).setOnClickListener(
            Navigation.createNavigateOnClickListener(R.id.action_notasListFragment_to_notasAddFragment)
        )


        // Configurar RecyclerView
        val recyclerNotas = rootView.findViewById<RecyclerView>(R.id.recyclerNotas)
        recyclerNotas.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.VERTICAL,
            false)
        val adapter = NotasAdapter()
        recyclerNotas.adapter = adapter

        NotasProvider.getProvider().listAll().forEach {
            Log.d("nota", it.toString())
        }
        NotasProvider.getProvider().registerListener {
            adapter.notifyDataSetChanged()
        }

        NotasProvider.getProvider().registerListener {
            Log.d("nota", "Cambiaron los datos")
        }

        return rootView
    }

}