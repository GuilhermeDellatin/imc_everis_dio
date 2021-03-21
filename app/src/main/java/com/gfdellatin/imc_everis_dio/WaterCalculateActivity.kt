package com.gfdellatin.imc_everis_dio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_water_calculate.*

class WaterCalculateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_water_calculate)

        btn_calculate_water?.setOnClickListener {
            if (switch_is_old.isChecked) waterConsumeOldPerson(outlinedTextInputWeightWater.text.toString())
            else if (switch_renal_desease.isChecked) waterConsumeDeseasePerson(outlinedTextInputWeightWater.text.toString())
            else if (switch_is_old.isChecked && switch_renal_desease.isChecked) especialConditionConsume(outlinedTextInputWeightWater.text.toString())
            else calculateWaterConsume(outlinedTextInputWeightWater.text.toString())
        }
    }

    private fun calculateWaterConsume(weightWater: String) {
        val weightWater = weightWater.toFloatOrNull()

        if (weightWater != null) {
            val waterQuantity = weightWater * 35
            water_text_result.text = getString(R.string.water_result).format(waterQuantity)
        }
    }

    private fun waterConsumeOldPerson(weightWaterOld: String) {
        val weightWaterOld = weightWaterOld.toFloatOrNull()

        if (weightWaterOld != null) {
            val waterOldQuantity = weightWaterOld * 25
            water_text_result.text = getString(R.string.water_result).format(waterOldQuantity)
        }
    }

    private fun waterConsumeDeseasePerson(weightWaterDesease: String) {
        val weightWaterDesease = weightWaterDesease.toFloatOrNull()

        if (weightWaterDesease != null) {
            val waterDeseaseQuantity = weightWaterDesease * 25
            water_text_result.text = getString(R.string.water_result).format(waterDeseaseQuantity)
        }
    }

    private fun especialConditionConsume(weightWaterEspecial: String) {
        val weightWaterEspecial = weightWaterEspecial.toFloatOrNull()

        if (weightWaterEspecial != null) {
            val waterEspecialConsume = weightWaterEspecial * 20
            water_text_result.text = getString(R.string.water_result).format(waterEspecialConsume)
        }
    }
}