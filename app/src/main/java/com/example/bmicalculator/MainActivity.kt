package com.example.bmicalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            calculateBMI()
        }
    }
    public fun calculateBMI(){

        if (editTextWeight.text.isEmpty()) {
            editTextWeight.setError(getString(R.string.error_input))
            return
        }
        if (editTextHeight.text.isEmpty()) {
            editTextHeight.setError(getString(R.string.error_input))
                return
        }

        val weight : Double = editTextWeight.text.toString().toDouble()
        val height : Double = editTextHeight.text.toString().toDouble()
        val bmi=weight/(height*height)

            textViewbmi.text = getString(R.string.BMI) + "${bmi}"
                if (bmi < 18.5) {
                textViewStatus.text =  getString(R.string.status) + " ${getString(R.string.underweight)}"
                imageViewProfileImage.setImageResource(R.drawable.under)
            } else if (bmi >= 18.5 && bmi <= 24.9) {
                textViewStatus.text = getString(R.string.status) + "${getString(R.string.normal)}"
                imageViewProfileImage.setImageResource(R.drawable.normal)
            } else {
                textViewStatus.text = getString(R.string.status) + "${getString(R.string.overweight)}"
                imageViewProfileImage.setImageResource(R.drawable.over)

            }



    }

    fun resetOutput(view : View){
        //TODO : clear all inputs and outputs
        editTextWeight.text=null
        editTextHeight.text=null
        imageViewProfileImage.setImageResource(R.drawable.empty)
        textViewbmi.text = ":${getString(R.string.nothing)}"
        textViewStatus.text = ":${getString(R.string.nothing)}"




    }
}
