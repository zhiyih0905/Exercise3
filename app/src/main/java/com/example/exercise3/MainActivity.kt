package com.example.exercise3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener(){
            Calculate()
        }

        buttonReset.setOnClickListener(){
            Reset()
        }
    }

    private fun Calculate(){
        val age = spinnerAge.selectedItem.toString()
        var isFemale = false
        var isSmoker = false

        if(radioButtonFemale.isChecked)
            isFemale = true

        if(checkBoxSmoker.isChecked)
            isSmoker = true

        var premium = 0 as Int
        when(age){
            "Less than 17" -> {
                premium = 60
            }
            "17 to 25" -> {
                premium = 70
                if(!isFemale)
                    premium += 50
                if(isSmoker)
                    premium += 100
            }
            "26 to 30" -> {
                premium = 90
                if(!isFemale)
                    premium += 100
                if(isSmoker)
                    premium += 150
            }
            "31 to 40" -> {
                premium = 120
                if(!isFemale)
                    premium += 150
                if(isSmoker)
                    premium += 200
            }
            "41 to 55" -> {
                premium = 150
                if(!isFemale)
                    premium += 200
                if(isSmoker)
                    premium += 250
            }
            "More than 55" -> {
                premium = 150
                if(!isFemale)
                    premium += 200
                if(isSmoker)
                    premium += 300
            }
            else -> {
                premium = 0
            }
        }

        if(!radioButtonFemale.isChecked && !radioButtonMale.isChecked)
            premium = 0

        textViewPremium.text = getString(R.string.insurance_premium) + " RM" + premium.toString()
    }

    private fun Reset(){
        spinnerAge.setSelection(0)
        radioButtonFemale.isChecked = false
        radioButtonMale.isChecked = false
        checkBoxSmoker.isChecked = false
        textViewPremium.text = getString(R.string.insurance_premium)
    }
}

