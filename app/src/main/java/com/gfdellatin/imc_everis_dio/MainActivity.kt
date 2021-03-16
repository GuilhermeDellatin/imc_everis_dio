package com.gfdellatin.imc_everis_dio


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {
        val imcButton = findViewById<MaterialButton>(R.id.button_imc)
        imcButton.setOnClickListener {
            //val intent = Intent(this, ResultActivity::class.java)
            startActivity(Intent(this, ResultActivity::class.java))
        }
        val tmbButton = findViewById<MaterialButton>(R.id.button_tmb)
        tmbButton.setOnClickListener {
            //val intent = Intent(this, ResultActivity::class)
            //startActivity(intent)
            startActivity(Intent(this, ResultActivity::class.java))
        }
    }
}