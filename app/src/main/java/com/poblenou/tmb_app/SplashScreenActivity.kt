package com.poblenou.tmb_app

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class SplashScreenActivity : AppCompatActivity() {
    private var isImageOneShowing = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val imageView = findViewById<ImageView>(R.id.imageView)

        val handler = Handler(mainLooper)
        handler.postDelayed(object : Runnable {
            override fun run() {
                if (isImageOneShowing) {
                    imageView.setImageResource(R.drawable.inicio2)
                    isImageOneShowing = false
                    handler.postDelayed(this, 2000) // Tiempo que se mostrará la segunda imagen
                } else {
                    // Iniciar actividad principal aquí después de mostrar la segunda imagen
                    val intent = Intent(this@SplashScreenActivity, MainActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }, 2000) // Tiempo que se mostrará la primera imagen
    }
}
