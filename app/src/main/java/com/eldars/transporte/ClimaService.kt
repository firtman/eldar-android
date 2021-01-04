package com.eldars.transporte

import android.app.IntentService
import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

/*
IntentService:
 1) Después de hacer su tarea, se elimina solo (onDestroy)
 2) Genera un thread por nosotros automáticamente

 */

class ClimaService : IntentService("Clima Service") {

    companion object {
        const val TAG = "ClimaService"
        const val ACTION_TEMPERATURA = "com.eldars.transporte.temperatura_lista"
        const val EXTRA_TEMPERATURA = "temp"
    }

    // Main Thread
    override fun onCreate() {
        Log.d(TAG, "onCreate")
        super.onCreate()
    }

    // Worker Thread
    override fun onHandleIntent(intent: Intent?) {
        val queue = Volley.newRequestQueue(this)
        val url = "https://www.google.com"

        // Request a string response from the provided URL.

        val request = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener {
                it.getJSONObject("main").getDouble("temp")
            },
            Response.ErrorListener {

            })

        // Add the request to the RequestQueue.
        queue.add(request)



        val temperatura: Float = 31F
        val broadcastIntent = Intent(ACTION_TEMPERATURA)
        broadcastIntent.putExtra(EXTRA_TEMPERATURA, temperatura)
        sendBroadcast(broadcastIntent)
    }


    // Main Thread
    override fun onDestroy() {
        Log.d(TAG, "onDestroy")
        super.onDestroy()
    }


}