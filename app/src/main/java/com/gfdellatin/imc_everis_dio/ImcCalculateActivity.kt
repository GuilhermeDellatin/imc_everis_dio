package com.gfdellatin.imc_everis_dio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isEmpty
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import com.google.android.material.textfield.TextInputLayout
import kotlinx.android.synthetic.main.activity_imc_calculate.*


class ImcCalculateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculate)

        btn_calculate_imc?.setOnClickListener {
            calculateImc(outlinedTextInputWeight.text.toString(), outlinedTextInputHeight.text.toString())
        }
    }


    private fun calculateImc(weight: String, height: String) {
        val weight = weight.toFloatOrNull()
        val height = height.toFloatOrNull()

        if (weight != null && height != null) {

            val imc = weight / (height * height)
            imc_text_result.text = getString(R.string.imc_result).format(imc)
        }
    }

}
