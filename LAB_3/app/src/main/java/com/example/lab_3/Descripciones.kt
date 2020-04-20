package com.example.lab_3

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.lab_3.databinding.ActivityDescripcionesBinding
import kotlinx.android.synthetic.main.activity_descripciones.*

class Descripciones : AppCompatActivity() {

    private lateinit var binding:ActivityDescripcionesBinding
    private var tipo = Tipo("","","")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_descripciones)

        binding.btnComentar.setOnClickListener(){
            val intent = Intent(this, MainActivity::class.java)
            val comentario= txtComentario.text.toString()
            if(comentario != ""){
                intent.putExtra("Comentario", comentario)
                startActivity(intent)//Inicia la actividad de Descripciones
                finish() // Finaliza una actividad
            }
            else{
                Toast.makeText(this, "Por favor, llene el espacio para comentar", Toast.LENGTH_SHORT).show()
            }
        }

        var boton = intent.getStringExtra("boton")
        var result = boton.toInt()

        if(result == 1) {
            tipo = Tipo(
                "#QUEDATEENCASA",
                "COVID-19: PROPAGACION",
                "La COVID-19 es la enfermedad infecciosa causada por el coronavirus que se ha descubierto más recientemente. Tanto el nuevo virus como la enfermedad eran desconocidos antes de que estallara el brote en Wuhan (China) en diciembre de 2019.\n" +
                        "   \nUna persona puede contraer la COVID-19 por contacto con otra que esté infectada por el virus. La enfermedad puede propagarse de persona a persona a través de las gotículas procedentes de la nariz o la boca que salen despedidas cuando una persona infectada tose o exhala.\n" +
                        "   \nEstas gotículas caen sobre los objetos y superficies que rodean a la persona, de modo que otras personas pueden contraer la COVID-19 si tocan estos objetos o superficies y luego se tocan los ojos, la nariz o la boca. También pueden contagiarse si inhalan las gotículas que haya esparcido una persona con COVID-19 al toser o exhalar.\n" +
                        "   \nPor eso es importante mantenerse a más de 1 metro (3 pies) de distancia de una persona que se encuentre enferma. La OMS está estudiando las investigaciones en curso sobre las formas de propagación de la COVID-19 y seguirá informando sobre los resultados actualizados.\n" +
                        "   \nLa principal forma de propagación de la enfermedad es a través de las gotículas respiratorias expelidas por alguien al toser. El riesgo de contraer la COVID-19 de alguien que no presente ningún síntoma es muy bajo. Sin embargo, muchas personas que contraen la COVID-19 solo presentan síntomas leves. Esto es particularmente cierto en las primeras etapas de la enfermedad. Por lo tanto, es posible contagiarse de alguien que, por ejemplo, solamente tenga una tos leve y no se sienta enfermo.\n" +
                        "   \nLa OMS está estudiando las investigaciones en curso sobre el periodo de transmisión de la COVID-19 y seguirá informando sobre los resultados actualizados."
            )
        }else if(result == 2){
            tipo = Tipo("#QUEDATEENCASA",
            "COVID-19: SÍNTOMAS",
                "La COVID‑19 afecta a las personas de distintas maneras. La mayoría de las personas infectadas desarrollan síntomas de leves a moderados."+
                    "\nSíntomas comunes:\n-Fiebre\n-Cansancio\n-Tos seca\nAlgunas personas también pueden experimentar:\n-Dolores y molestias\n-Congestión nasal\n-Abundante secreción nasal\n-Dolor de garganta\n-Diarrea\n" +
                    "\nCuando una persona se infecta con el virus, los síntomas tardan en aparecer en término medio de 5 a 6 días, pero pueden tardar hasta 14 días.\n" +
                    "\nAlgunas personas se infectan pero no desarrollan ningún síntoma y no se encuentran mal. La mayoría de las personas (alrededor del 80%) se recupera de la enfermedad sin necesidad de realizar ningún tratamiento especial. Alrededor de 1 de cada 6 personas que contraen la COVID-19 desarrolla una enfermedad grave y tiene dificultad para respirar.\n" +
                    "\nLas personas mayores y las que padecen afecciones médicas subyacentes, como hipertensión arterial, problemas cardiacos o diabetes, tienen más probabilidades de desarrollar una enfermedad grave. En torno al 2% de las personas que han contraído la enfermedad han muerto." +
                    "\nLas personas que tengan fiebre, tos y dificultad para respirar deben buscar atención médica.")
        }else{
            tipo = Tipo("#QUEDATEENCASA",
                "COVID-19: INDICACIONES DE CONTAGIO",
                "*Quédese en casa, excepto para conseguir atención médica\n" +
                        "Debe restringir las actividades fuera de su casa, excepto para conseguir atención médica. No vaya al trabajo, la escuela o a áreas públicas. Evite usar el servicio de transporte público, vehículos compartidos o taxis.\n" +
                        "\n*Manténgase alejado de otras personas y de los animales en su casa\n" +
                        "-Personas: en la medida de lo posible, permanezca en una habitación específica y lejos de las demás personas que estén en su casa. Además, debería usar un baño aparte, de ser posible.\n" +
                        "-Animales: mientras esté enfermo, no manipule ni toque mascotas ni otros animales. Consulte El COVID-19 y los animales para obtener más información.\n" +
                        "\n*Llame antes de ir al médico\n" +
                        "Si tiene una cita médica, llame al proveedor de atención médica y dígale que tiene o que podría tener COVID-19. Esto ayudará a que en el consultorio del proveedor de atención médica se tomen medidas para evitar que otras personas se infecten o expongan.\n" +
                        "\n*Use una mascarilla\n" +
                        "Usted debería usar una mascarilla cuando esté cerca de otras personas (p. ej., compartiendo una habitación o un vehículo) o de mascotas y antes de entrar al consultorio de un proveedor de " +
                        "atención médica. Si no puede usar una mascarilla (por ejemplo, porque le causa dificultad para respirar), las personas que vivan con usted no deberían permanecer con usted en la misma habitación, o deberían ponerse una mascarilla si entran a su habitación.\n" +
                        "\n*Cúbrase la nariz y la boca al toser y estornudar\n" +
                        "Cúbrase la nariz y la boca con un pañuelo desechable al toser o estornudar. Bote los pañuelos desechables usados en un bote de basura con una bolsa de plástico adentro; lávese inmediatamente las manos con agua y jabón por al menos 20 segundos o límpieselas con " +
                        "un desinfectante de manos que contenga al menos 60 % de alcohol, cubra todas las superficies de las manos y fróteselas hasta que sienta que se secaron. Si tiene las manos visiblemente sucias, es preferible usar agua y jabón.\n" +
                        "\n*Evite compartir artículos del hogar de uso personal\n" +
                        "No debe compartir platos, vasos, tazas, cubiertos, toallas o ropa de cama con otras personas o mascotas que estén en su casa. Después de usar estos artículos, se los debe lavar bien con agua y jabón.")
        }

        binding.tipo = tipo
    }


}
