package com.eldars.transporte


class API {

    companion object {
        fun login(usuario: String, contrasena: String, callback: (ok: Boolean)->Unit) {
            if (usuario=="admin" && contrasena=="12345") {
                callback(true)
            } else {
                callback(false)
            }
        }
    }

    fun instancia() {

    }

}