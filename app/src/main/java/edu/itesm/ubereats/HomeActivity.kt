package edu.itesm.ubereats

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        // Abilita las banderas de la ventana para que no se ponga el titulo ese que tapa
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        // Un manejador para que espere 3000 milisegundos y haga el intent para cambiar de actividad
        Handler().postDelayed({

            // Creamos un intento, recibe como parametros donde estamos y a que actividad vamos
            val intento = Intent(this, MainActivity::class.java)

            // Lanza la actividad
            startActivity(intento)

            // Termina el ciclo de vida del intento
            finish()
        }, 3000)
    }
}