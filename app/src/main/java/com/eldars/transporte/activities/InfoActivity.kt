package com.eldars.transporte.activities

import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Message
import android.view.KeyEvent
import android.webkit.*
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.eldars.transporte.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

class InfoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        // Abre el navegador en una URL - tel: para llamar por teléfono
//        val intentImplicito = Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com"))
//        startActivity(intentImplicito)

        val webview = findViewById<WebView>(R.id.webview)
//        webview.loadData("<h1>Hola desde Kotlin</h1><marquee>Hey!</marquee>",
//            "text/html", "utf-8")

        val texto = "Hola desde Kotlin"
        findViewById<FloatingActionButton>(R.id.fabJavaScript).setOnClickListener {
            webview.evaluateJavascript("recibeInfo('$texto')") { resultado ->

            }
        }

        webview.settings.javaScriptEnabled = true
        webview.settings.userAgentString = "Eldar Navigator Web Sarasa 1.0"


        webview.webChromeClient = object: WebChromeClient() {

        }
        webview.webViewClient = object: WebViewClient() {

        }

        val check = ContextCompat.checkSelfPermission(this,
                "android.permission.ACCESS_COARSE_LOCATION")

        if (check != PackageManager.PERMISSION_GRANTED) {
            // Pedimos permiso
            requestPermissions(arrayOf("android.permission.ACCESS_COARSE_LOCATION"), 140);
        } else {
            // El usuario me dio permiso y ya estoy listo para activar la geolocalización

        }

        webview.addJavascriptInterface(
            object {

                @JavascriptInterface
                fun mostrarToast(texto: String) {
                    Toast.makeText(this@InfoActivity, texto, Toast.LENGTH_SHORT).show()
                }

            },
        "native")
        webview.loadUrl("file:///android_asset/infoutil.html")

    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<out String>,
                                            grantResults: IntArray) {
        if (requestCode==140) {
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED) {
                // El usuario me dio permiso y ya estoy listo para activar la geolocalización
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {

        return super.onKeyUp(keyCode, event)
    }
}