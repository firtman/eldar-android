package com.eldars.transporte

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.FragmentManager

class ClimaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_clima)



        // ESCUCHA UN BROADCAST - BROADCAST RECEIVER
        val intentFilter = IntentFilter(ClimaService.ACTION_TEMPERATURA)
        this.registerReceiver(object: BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                val temperatura = intent?.getFloatExtra(ClimaService.EXTRA_TEMPERATURA,
                    -200F) ?: -300F
               Toast.makeText(this@ClimaActivity, "Llego Temperatura $temperatura", Toast.LENGTH_LONG).show()
            }

        }, intentFilter)

        // COMIENZA UN SERVICIO
        val intent = Intent(this, ClimaService::class.java)
        startService(intent)

    }
}
//
//class ClimaReceiver: BroadcastReceiver() {
//    override fun onReceive(context: Context?, intent: Intent?) {
//        TODO("Not yet implemented")
//    }
//
//}