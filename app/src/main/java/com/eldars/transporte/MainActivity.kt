package com.eldars.transporte

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AlertDialog


class MainActivity : AppCompatActivity() {

    companion object {
        const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonLogin = findViewById<Button>(R.id.buttonLogIn)
        val editUsuario = findViewById<EditText>(R.id.editUsuario)
        val editContrasena = findViewById<EditText>(R.id.editContrasena)

        buttonLogin.setOnClickListener {
            val usuario = editUsuario.text.toString()
            val contrasena = editContrasena.text.toString()


            API.login(usuario, contrasena) { respuesta ->
                if (respuesta) {
                    // Está logueado ok
                    Log.d(TAG, "Está todo ok")
                } else {
                    Log.d(TAG, "Está todo mal")
                    val alerta = AlertDialog.Builder(this)
                            .setTitle(getString(R.string.button_login))
                            .setMessage(getString(R.string.login_mensaje_invalido))
                            .setPositiveButton(R.string.button_aceptar) { _, _ ->

                            }

                    alerta.show()
                }
            }





//            Toast.makeText(this, "El usuario es $usuario!", Toast.LENGTH_LONG).show()
        }
    }
}