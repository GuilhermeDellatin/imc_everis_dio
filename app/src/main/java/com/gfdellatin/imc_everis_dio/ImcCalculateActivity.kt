package com.gfdellatin.imc_everis_dio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout

class ImcCalculateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculate)
    }

    private fun setListenersImc() {

        val outlinedTextFieldWeight = findViewById<TextInputLayout>(R.id.outlinedTextFieldWeight)
        outlinedTextFieldWeight.editText?.text.toString()

        outlinedTextFieldWeight.editText?.doOnTextChanged { text, _, _, _ ->
            if (outlinedTextFieldWeight.isEmpty())
                Toast.makeText(this, "Digite seu Peso", Toast.LENGTH_SHORT).show()
        }

        val outlinedTextFieldHeight = findViewById<TextInputLayout>(R.id.outlinedTextFieldHeight)
        outlinedTextFieldHeight.editText?.text.toString()
        
        outlinedTextFieldHeight.editText?.doAfterTextChanged { text ->
            if (outlinedTextFieldHeight.isEmpty())
            Toast.makeText(this, "Digite sua Altura", Toast.LENGTH_SHORT).show()
        }

        val calculateImcButton = findViewById<Button>(R.id.btn_calculate_imc)
        calculateImcButton.setOnClickListener {
            val myImc = calculateImc(outlinedTextFieldWeight.toString(), outlinedTextFieldHeight.toString())
            val imcResponse = "IMC: " + myImc + "\n" + checkImc(myImc)
        }
    }

    private fun calculateImc(weight: String, height: String): Double  = weight.toDouble() / (height.toDouble() * height.toDouble())

    private fun checkImc(checkMyImc: Double): String {
        return when(checkMyImc) {
            in 0.0..17.0 -> "Muito abaixo do peso."
            in 17.1..18.49 -> "Abaixo do peso."
            in 18.5..24.99 -> "Peso normal."
            in 25.0..29.99 ->  "Acima do peso."
            in 30.0..34.99 -> "Obesidade I."
            in 35.0..39.99 -> "Obesidade II(Severa)."
            else -> "Obesidade III(mórbida)."
        }
    }

}