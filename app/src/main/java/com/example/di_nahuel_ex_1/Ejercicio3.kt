package com.example.di_nahuel_ex_1

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Ejercicio3 : AppCompatActivity() {
    private lateinit var icono: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_ejercicio3)

        icono = findViewById(R.id.iconoSup)


        icono.setOnClickListener{
            val intent = Intent(this, Ejercicio1::class.java)
            startActivity(intent)
        }
    }
}