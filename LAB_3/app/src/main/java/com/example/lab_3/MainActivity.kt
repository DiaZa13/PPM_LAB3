package com.example.lab_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Risk.setOnClickListener(){
            Riesgo()
        }

        btnVirus.setOnClickListener(){
            val intent = Intent(this, Descripciones::class.java)
            startActivity(intent)//Inicia la actividad de Descripciones
            intent.putExtra("boton", 1)
            finish() // Finaliza una actividad
        }

        btnSintomas.setOnClickListener(){
            val intent = Intent(this, Descripciones::class.java)
            startActivity(intent)//Inicia la actividad de Descripciones
            intent.putExtra("boton", 2)
            finish() // Finaliza una actividad
        }

        btnIndicaciones.setOnClickListener(){
            val intent = Intent(this, Descripciones::class.java)
            startActivity(intent)//Inicia la actividad de Descripciones
            intent.putExtra("boton", 3)
            finish() // Finaliza una actividad
        }
        //Extrae el comentario ingresado
        var comentario = intent.getStringExtra("Comentario")
        //Verifica que el comentario no este vacio, y luego lo muestra en pantalla
        if(comentario != null)
            Toast.makeText(this, comentario, Toast.LENGTH_SHORT).show()

    }

    //Calcula el riesgo que sufre la persona de muerte si esta contrae el virus y le muestra un mensaje con el mismo
    private fun Riesgo(){
        val nombre = txtNombre.text.toString()//Extrae el nombre ingresado por el usuario
        val edad = txtEdad.text.toString().toIntOrNull()//Extrae la edad ingresada por el usuario
        var mensaje : String = " "//Almacena el mensaje de riesgo para el usuario

        if(nombre == null || edad == null){
            Toast.makeText(this, "Ingrese su nombre y su edad para conocer el riesgo que corre", Toast.LENGTH_SHORT).show()
        }else if(edad  < 0 || edad > 100){
            Toast.makeText(this, "Por favor ingrese yun valor de edad válido", Toast.LENGTH_SHORT).show()
        }else if(lblRiesgo.visibility == View.VISIBLE){//Si ya esta mostrando el mensaje de riesgo, regresa a mostrar los datos del usuario
            lblNombre.visibility = View.VISIBLE
            lblEdad.visibility = View.VISIBLE
            txtNombre.visibility = View.VISIBLE
            txtEdad.visibility = View.VISIBLE
            lblRiesgo.visibility = View.INVISIBLE
        } else {//Si todos los datos ingresados por el usuario estan bien, analiza la edad y le muestra el riesgo
            if(edad < 10)
            mensaje =  "${nombre.toString()} cuentas con un 0% de probabilidad de riesgo si contraes el virus "
            else if(edad < 40)
                mensaje =  "${nombre.toString()} cuentas con un 0.2% de probabilidad de riesgo si contraes el virus "
            else if(edad < 60)
                mensaje =  "${nombre.toString()} cuentas con un 1.3% de probabilidad de riesgo si contraes el virus "
            else if(edad < 70)
                mensaje =  "${nombre.toString()} cuentas con un 3.6% de probabilidad de riesgo si contraes el virus "
            else if(edad < 80)
                mensaje =  "${nombre.toString()} cuentas con un 8% de probabilidad de riesgo si contraes el virus "
            else if(edad > 80)
                mensaje =  "${nombre.toString()} cuentas con un 14.8% de probabilidad de riesgo si contraes el virus "
            lblNombre.visibility = View.INVISIBLE
            lblEdad.visibility = View.INVISIBLE
            txtNombre.visibility = View.INVISIBLE
            txtEdad.visibility = View.INVISIBLE
            lblRiesgo.visibility = View.VISIBLE
            lblRiesgo.text = mensaje
        }
    }
}
