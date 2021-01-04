package com.eldars.transporte

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.FragmentManager

class ClimaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clima)




    }
}
//
//class ClimaReceiver: BroadcastReceiver() {
//    override fun onReceive(context: Context?, intent: Intent?) {
//        TODO("Not yet implemented")
//    }
//
//}