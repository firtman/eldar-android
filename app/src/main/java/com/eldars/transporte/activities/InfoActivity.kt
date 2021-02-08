package com.eldars.transporte.activities

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.webkit.*
import com.eldars.transporte.R

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

        webview.settings.javaScriptEnabled = true
        webview.settings.userAgentString = "Eldar Navigator Web Sarasa 1.0"

        webview.webChromeClient = object: WebChromeClient() {

        }
        webview.webViewClient = object: WebViewClient() {

        }
        webview.loadUrl("file:///android_asset/infoutil.html")

    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {

        return super.onKeyUp(keyCode, event)
    }
}