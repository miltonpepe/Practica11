package com.tallercmovil.esprimo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tallercmovil.esprimo.databinding.ActivitySplahs2Binding
import kotlin.concurrent.thread

class Splahs2 : AppCompatActivity() {

    private lateinit var binding: ActivitySplahs2Binding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding= ActivitySplahs2Binding.inflate(layoutInflater)

        setContentView(binding.root)

        thread{
            Thread.sleep(3000)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}