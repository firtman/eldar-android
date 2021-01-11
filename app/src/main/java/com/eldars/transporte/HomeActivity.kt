package com.eldars.transporte

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit

class HomeActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        Log.d("LifeCycle", "onCreate")

        val btnClima: Button = findViewById(R.id.btnClima)
        btnClima.setOnClickListener {
            val intent = Intent(this, ClimaActivity::class.java)
            startActivity(intent)
        }

        val btnMisNotas: Button = findViewById(R.id.btnMisNotas)
        btnMisNotas.setOnClickListener {
            val intent = Intent(this, NotasActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflador = MenuInflater(this)
        inflador.inflate(R.menu.home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_logout) {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()

            val preferences = getSharedPreferences(LoginActivity.PREFS_LOGIN, Context.MODE_PRIVATE)
            preferences.edit {
                putBoolean(LoginActivity.KEY_ESTA_LOGUEADO, false)
            }

        }
        return super.onOptionsItemSelected(item)
    }

    override fun onRestart() {
        Log.d("LifeCycle", "onRestart")

        super.onRestart()
    }

    override fun onPause() {
        Log.d("LifeCycle", "onPause")

        super.onPause()
    }

    override fun onStop() {
        // Mi última cena
        // 5 segundos máximo, no estamos visibles
        Log.d("LifeCycle", "onStop")

        super.onStop()
    }
}