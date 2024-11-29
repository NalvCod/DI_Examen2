package com.example.di_nahuel_ex_1

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.textfield.TextInputLayout
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.TimeZone

class MainActivity : AppCompatActivity() {
    //inicializamos botones
    private lateinit var nombreLayout: TextInputLayout
    private lateinit var nombre: EditText

    private lateinit var estaturaLayout: TextInputLayout
    private lateinit var estatura: EditText

    private lateinit var entrenadorLayout: TextInputLayout
    private lateinit var entrenador: EditText

    private lateinit var fecha: EditText

    private lateinit var spinner: Spinner
    private lateinit var anadir: ImageView

    private lateinit var icono: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        nombreLayout = findViewById(R.id.layoutNombre)
        nombre = findViewById(R.id.nombre)

        estaturaLayout = findViewById(R.id.estaturaLayout)
        estatura = findViewById(R.id.estatura)

        entrenadorLayout = findViewById(R.id.layoutEntrenador)
        entrenador = findViewById(R.id.entrenador)

        anadir = findViewById(R.id.botonAnadir)
        icono = findViewById(R.id.iconoSup)
        fecha = findViewById(R.id.fecha)

        val spinner: Spinner = findViewById(R.id.bloque1)
        val items = listOf("Fuego", "Roca", "Agua", "Tierra", "Electricidad", "Hielo", "Normal", "Psíquico", "Bicho", "Dragón", "Fantasma", "Volador")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, items)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

        spinner.adapter = adapter

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                p0: AdapterView<*>?,
                vista: View?,
                posicion: Int,
                id: Long
            ) {
                val selectedItem = items[posicion]
                Toast.makeText(this@MainActivity, selectedItem, Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        icono.setOnClickListener{
            val intent = Intent(this, Ejercicio1::class.java)
            startActivity(intent)
        }
        anadir.setOnClickListener {
            validarNombre(nombre.text.toString()
            )
            validarEntrenador(
                entrenador.text.toString()
            )
        }
    }
}

    fun validarNombre(nombre: String): Boolean {
        return if (nombre.length < 3 || nombre[0].isLowerCase()) {
            false
        } else {
            true
        }
    }

    fun validarEntrenador(entrenador: String): Boolean {
        if (entrenador.length > 25) {
            return false
        } else {
            return true
        }
    }



