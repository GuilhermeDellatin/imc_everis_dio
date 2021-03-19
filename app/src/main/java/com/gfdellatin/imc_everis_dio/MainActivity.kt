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
            startActivity(Intent(this, ImcCalculateActivity::class.java))
        }
        val tmbButton = findViewById<MaterialButton>(R.id.button_tmb)
        tmbButton.setOnClickListener {
            startActivity(Intent(this, ImcCalculateActivity::class.java))
        }
    }
}