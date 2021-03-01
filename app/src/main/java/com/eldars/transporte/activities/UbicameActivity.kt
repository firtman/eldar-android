package com.eldars.transporte.activities

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.app.ActivityCompat
import com.eldars.transporte.R
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices

class UbicameActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_LOCATION_PERMISSIONS_CODE = 100
    }

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubicame)

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this)

        findViewById<Button>(R.id.btnUbicar).setOnClickListener {
            pedirUbicacion()
        }

    }

    private fun pedirUbicacion() {
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // No tenemos el permiso, lo pedimos
            ActivityCompat.requestPermissions(
                this, arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION
                ), REQUEST_LOCATION_PERMISSIONS_CODE
            )
        } else {
            // Tengo permiso
            fusedLocationClient.lastLocation.addOnSuccessListener {
//                val locationCentral = Location.convert("3434, 3434")
//                val distancia = it.distanceTo(locationCentral)
                if (it!=null) {
                    findViewById<TextView>(R.id.txtUbicacion).text =
                        "Latitud: ${it.latitude} ${it.longitude}"
                }
            }

        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == REQUEST_LOCATION_PERMISSIONS_CODE) {
            pedirUbicacion()
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }
}