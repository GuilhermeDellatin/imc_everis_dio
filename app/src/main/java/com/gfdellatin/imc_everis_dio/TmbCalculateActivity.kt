package com.gfdellatin.imc_everis_dio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.activity_tmb_calculate.*


class TmbCalculateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tmb_calculate)

        val sexList = listOf("Masculino", "Feminino")
        val adapterSexList = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, sexList)
        select_gender_spinner.adapter = adapterSexList

        var selectedPosition: Int = 0
        select_gender_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                selectedPosition = position
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

        }

        btn_calculate_tmb?.setOnClickListener {
            when (selectedPosition) {
                0 -> calculateTmbMasc(outlinedTextInputWeightTmb.text.toString(), outlinedTextInputHeightTmb.text.toString(),
                outlinedTextInputAge.text.toString())

                else -> calculateTmbFem(outlinedTextInputHeightTmb.text.toString(), outlinedTextInputHeightTmb.text.toString(),
                        outlinedTextInputAge.text.toString())

            }
        }

    }


    private fun calculateTmbMasc(weightTmb: String, heightTmb: String, age: String) {
        val weightTmb = weightTmb.toFloatOrNull()
        val heightTmb = heightTmb.toFloatOrNull()
        val age = age.toFloatOrNull()

        if (weightTmb != null && heightTmb != null && age != null) {
            val tmb = (13.8 * weightTmb) + (5.0 * heightTmb) - (6.8 - age)
            tmb_text_result.text = getString(R.string.tmb_result).format(tmb)
        }

    }

    private fun calculateTmbFem(weightTmb: String, heightTmb: String, age: String) {
        val weightTmb = weightTmb.toFloatOrNull()
        val heightTmb = heightTmb.toFloatOrNull()
        val age = age.toFloatOrNull()

        if (weightTmb != null && heightTmb != null && age != null) {
            val tmb = (9.6 * weightTmb) + (1.8 * heightTmb) - (4.7 - age)
            tmb_text_result.text = getString(R.string.tmb_result).format(tmb)
        }

    }
}