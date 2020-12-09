package com.eldars.transporte

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonLogin = findViewById<Button>(R.id.buttonLogIn)

        val editUsuario = findViewById<EditText>(R.id.editUsuario)

        buttonLogin.setOnClickListener {
            val usuario = editUsuario.text.toString()
            Toast.makeText(this, "El usuario es $usuario!", Toast.LENGTH_LONG).show()
        }
    }
}