package com.example.calcvert

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.calcvert.databinding.ActivityMassBinding

class MassActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMassBinding.inflate(layoutInflater)
    }
    private val units = arrayOf("Kilogram","Gram","Pound","Tonne","Milligram","Micrograms","Carat")
    private val conversionMatrix = arrayOf(
        // Meters to other units
        doubleArrayOf(1.0, 0.000621371, 100.0, 3.28084, 0.001, 1000.0, 10.0, 39.3701, 1.09361),
        // Miles to other units
        doubleArrayOf(1609.34, 1.0, 160934.0, 5280.0, 1.60934, 1.60934e+6, 16093.4, 63360.0, 1760.0),
        // Centimeters to other units
        doubleArrayOf(0.01, 6.2137e-6, 1.0, 0.0328084, 1e-5, 100.0, 0.1, 0.393701, 0.0109361),
        // Feet to other units
        doubleArrayOf(0.3048, 0.000189394, 30.48, 1.0, 0.0003048, 304.8, 3.048, 12.0, 0.333333),
        // Kilometers to other units
        doubleArrayOf(1000.0, 0.621371, 100000.0, 3280.84, 1.0, 1e+6, 10000.0, 39370.1, 1093.61),
        // Millimeters to other units
        doubleArrayOf(0.001, 6.2137e-7, 0.1, 3.2808e-3, 1e-6, 1.0, 0.01, 0.0393701, 0.00109361),
        // Decimeters to other units
        doubleArrayOf(0.1, 6.2137e-5, 10.0, 0.328084, 0.0001, 100.0, 1.0, 3.93701, 0.109361),
        // Inches to other units
        doubleArrayOf(0.0254, 1.5783e-5, 2.54, 0.0833333, 2.54e-5, 25.4, 0.254, 1.0, 0.0277778),
        // Yards to other units
        doubleArrayOf(0.9144, 0.000568182, 91.44, 3.0, 0.0009144, 914.4, 9.144, 36.0, 1.0)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        // Set up spinners with ArrayAdapter
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item,units)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.spinnerFromMasss.adapter=adapter
        binding.spinnerToMasss.adapter = adapter

        // Set up button click listener
        binding.btnconvertMass.setOnClickListener {
            convertUnits()
        }
    }

    private fun convertUnits() {
        val fromUnitIndex = binding.spinnerFromMasss.selectedItemPosition
        val toUnitIndex = binding.spinnerToMasss.selectedItemPosition

        if (fromUnitIndex == toUnitIndex) {
            binding.textResultMass.text = "Please select different units."
            return
        }

        try {
            val inputValue = binding.editTextValue.text.toString().toDouble()
            val conversionFactor = conversionMatrix[fromUnitIndex][toUnitIndex]
            val result = inputValue * conversionFactor
            binding.textResultMass.text = "$inputValue ${units[fromUnitIndex]} is $result ${units[toUnitIndex]}"
        } catch (e: NumberFormatException) {
            binding.textResultMass.text = "Invalid input. Please enter a valid number."
        }
    }






}