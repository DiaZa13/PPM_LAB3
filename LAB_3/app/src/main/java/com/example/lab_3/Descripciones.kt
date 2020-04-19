package com.example.lab_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_descripciones.*

class Descripciones : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_descripciones)


        btnComentar.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            val comentario = txtComentario.text.toString()
            if(comentario == null)
                Toast.makeText(this, "Por favor, llene el espacio para comentar", Toast.LENGTH_SHORT).show()
            else{
                intent.putExtra("Comentario", comentario)
                startActivity(intent)//Inicia la actividad de Descripciones
                finish() // Finaliza una actividad
            }

        }

    }
}
