package com.tallercmovil.esprimo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.tallercmovil.esprimo.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun click(vista: View){

        with(binding) {
            if (validaCampos()) {
                //val numero = Integer.parseInt(etNumero.text.toString())
                val numero = etNumero.text.toString().toInt()
                if (esPrimo(numero)) tvResultado.text = getString(R.string.si_primo, numero, "!")
                else tvResultado.text = getString(R.string.no_primo, numero)


            } else {

                Toast.makeText(this@MainActivity, getString(R.string.ingresa_valor), Toast.LENGTH_SHORT).show()
                etNumero.error = getString(R.string.valor_requerido)
                etNumero.requestFocus()

                //Para hacer que una vista desaparezca
                //binding.etNumero.visibility = View.INVISIBLE

                //Para hacer que una vista aparezca
                //binding.etNumero.visibility = View.VISIBLE
            }
        }

    }

    private fun esPrimo(numero: Int): Boolean{
        if(numero <= 1 ) return false
        else{
            for(i in 2 until numero){
                if(numero%i == 0) return false
            }
        }
        return true
    }

    private fun validaCampos(): Boolean{

        /*Sin View Binding:
        val etNumero = findViewById<EditText>(R.id.etNumero)
        if(etNumero)*/

        if(binding.etNumero.text.toString() != "" ) return true
        else return false

    }
}