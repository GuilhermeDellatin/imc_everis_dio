package com.gfdellatin.imc_everis_dio


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setListeners()
    }

    private fun setListeners() {

        button_imc?.setOnClickListener {
            startActivity(Intent(this, ImcCalculateActivity::class.java))
        }

        button_tmb?.setOnClickListener {
            startActivity(Intent(this, TmbCalculateActivity::class.java))
        }

        button_water.setOnClickListener {
            startActivity(Intent(this,WaterCalculateActivity::class.java))
        }
    }
}