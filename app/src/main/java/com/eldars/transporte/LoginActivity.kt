package com.eldars.transporte

import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AlertDialog
import androidx.core.content.edit


class LoginActivity : AppCompatActivity() {

    val empresas = listOf<String>("HP", "IBM", "Google", "Apple")

    companion object {
        const val TAG = "MainActivity"
        const val KEY_ESTA_LOGUEADO = "estaLogueado"
        const val PREFS_LOGIN = "login"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val spinnerEmpresa = findViewById<Spinner>(R.id.spinnerEmpresa)
        val adaptador = ArrayAdapter(this,
                android.R.layout.simple_spinner_item, empresas)
        adaptador.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
        spinnerEmpresa.adapter = adaptador

        val buttonLogin = findViewById<Button>(R.id.buttonLogIn)
        val editUsuario = findViewById<EditText>(R.id.editUsuario)
        val editContrasena = findViewById<EditText>(R.id.editContrasena)

        // Persistir un token para hacer autologin
        val preferences = getSharedPreferences(PREFS_LOGIN, Context.MODE_PRIVATE)
        val estaLogueado = preferences.getBoolean(KEY_ESTA_LOGUEADO, false)
        if (estaLogueado) {
            goToHome()
        }

        buttonLogin.setOnClickListener {
            val usuario = editUsuario.text.toString()
            val contrasena = editContrasena.text.toString()


            API.login(usuario, contrasena) { respuesta ->
                if (respuesta) {
                    // Está logueado ok
                    Log.d(TAG, "Está todo ok")
                    goToHome()
                    // grabar datos
                    preferences.edit {
                        putBoolean(KEY_ESTA_LOGUEADO, true)
                    }


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

    private fun goToHome() {
        // Va a un nuevo activity
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }
}