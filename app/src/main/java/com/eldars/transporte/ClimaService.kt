package com.eldars.transporte

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class ClimaService : Service() {

    companion object {
        const val TAG = "ClimaService"
        const val ACTION_TEMPERATURA = "com.eldars.transporte.temperatura_lista"
        const val EXTRA_TEMPERATURA = "temp"
    }

    override fun onCreate() {
        Log.d(TAG, "onCreate")
        super.onCreate()
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand")
        val temperatura: Float = 31F
        val broadcastIntent = Intent(ACTION_TEMPERATURA)
        broadcastIntent.putExtra(EXTRA_TEMPERATURA, temperatura)
        sendBroadcast(broadcastIntent)

        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }


    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}