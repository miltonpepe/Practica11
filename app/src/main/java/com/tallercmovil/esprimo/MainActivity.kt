package com.tallercmovil.esprimo

import android.os.Bundle
import android.util.Log
import android.util.Log.ERROR
import android.view.Menu
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.tallercmovil.esprimo.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private var formula = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)
//        SPINNER
        val arraySpinner = arrayOf(
            "Triangulo", "Rectangulo", "Pentágono"
        )
        val adapter: ArrayAdapter<String> = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_item, arraySpinner
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.Spinner01.setAdapter(adapter)

        binding.Spinner01.setOnItemSelectedListener(object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parentView: AdapterView<*>?,
                selectedItemView: View?,
                position: Int,
                id: Long
            ) {
                // your code here
                binding.tvResultado.setText( "Has seleccionado el " + arraySpinner[position] )

                formula = position

                var imageID = R.drawable.geometrico
                when ( position ) {
                    0 -> {
                        binding.inputa.setText("")
                        binding.inputb.setText("")
                        binding.resFinal.setText("")


                        imageID = R.drawable.triangulo
//                        binding.label2.visibility = View.VISIBLE
//                        binding.inputb.visibility = View.VISIBLE
                        binding.label1.setText(R.string.t_base)
                        binding.label2.setText(R.string.t_altura)

                    }
                    1 -> {
                        binding.inputa.setText("")
                        binding.inputb.setText("")
                        binding.resFinal.setText("")

                        imageID = R.drawable.rectangulo
                        binding.label1.setText(R.string.r_ladom)
                        binding.label2.setText(R.string.r_ladomm)

//                        binding.label2.visibility = View.INVISIBLE
//                        binding.inputb.visibility = View.INVISIBLE
                    }
                    2 -> {
                        binding.inputa.setText("")
                        binding.inputb.setText("")
                        binding.resFinal.setText("")

                        imageID = R.drawable.pentagono
                        binding.label1.setText(R.string.p_apotema)
                        binding.label2.setText(R.string.p_lado)

//                        binding.label2.visibility = View.INVISIBLE
//                        binding.inputb.visibility = View.INVISIBLE
                    }

                }
                binding.imageView.setImageResource( imageID )


            }

            override fun onNothingSelected(parentView: AdapterView<*>?) {
                // your code here
            }
        })

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return super.onCreateOptionsMenu(menu)
    }

    fun clic(view: View) {
        if(binding.inputa.text.toString() == "" || binding.inputb.text.toString() == ""){

            Toast.makeText(this@MainActivity, getString(R.string.ingresa_valor), Toast.LENGTH_SHORT).show()

        }else{
            Log.e("FORM", formula.toString())

            when(formula){
                0 -> {
                    var a = binding.inputa.text.toString().toInt()
                    var b = binding.inputb.text.toString().toInt()
                    binding.resFinal.setText( ((a * b) / 2 ).toString() )
                }
                1 -> {
                    var a = binding.inputa.text.toString().toInt()
                    var b = binding.inputb.text.toString().toInt()

                    binding.resFinal.setText( (a * b).toString() )
                }
                2 -> {
                    var a = binding.inputa.text.toString().toInt()
                    var b = binding.inputb.text.toString().toInt()
                    binding.resFinal.setText( ((a * b * 5) / 2 ).toString() )

                }
            }
        }








    }

}
