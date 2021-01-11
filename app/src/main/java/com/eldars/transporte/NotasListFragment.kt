package com.eldars.transporte

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController

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
        return rootView
    }

}