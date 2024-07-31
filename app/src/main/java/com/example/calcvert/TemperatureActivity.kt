package com.example.calcvert

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.calcvert.databinding.ActivityTemperatureBinding

class TemperatureActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityTemperatureBinding.inflate(layoutInflater)
    }
    // Define the units for temperature conversion
    private val units = arrayOf("Celsius", "Fahrenheit", "Kelvin")

    // Define the conversion matrix for temperature units
    private val conversionMatrix = arrayOf(
        // Conversion factors for Celsius to other units:
        // Row 0: Celsius to Celsius, Fahrenheit, Kelvin
        doubleArrayOf(1.0, 33.8, 274.15),
        // Conversion factors for Fahrenheit to other units:
        // Row 1: Fahrenheit to Celsius, Fahrenheit, Kelvin
        doubleArrayOf(-17.2222, 1.0, 255.928),
        // Conversion factors for Kelvin to other units:
        // Row 2: Kelvin to Celsius, Fahrenheit, Kelvin
        doubleArrayOf(-272.15, -457.87, 1.0)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, units)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerFromTemperature.adapter = adapter
        binding.spinnerToTemperature.adapter = adapter

        // Set up button click listener
        binding.btnconvertTemperature.setOnClickListener {
            convertUnits()
        }
    }

    private fun convertUnits() {
        val fromUnitIndex = binding.spinnerFromTemperature.selectedItemPosition
        val toUnitIndex = binding.spinnerToTemperature.selectedItemPosition

        if (fromUnitIndex == toUnitIndex) {
            binding.textResultTemperature.text = "Please select different units."
            return
        }

        try {
            val inputValue = binding.editTextValue.text.toString().toDouble()
            val conversionFactor = conversionMatrix[fromUnitIndex][toUnitIndex]
            val result = inputValue * conversionFactor
            binding.textResultTemperature.text = "$inputValue ${units[fromUnitIndex]} is $result ${units[toUnitIndex]}"
        } catch (e: NumberFormatException) {
            binding.textResultTemperature.text = "Invalid input. Please enter a valid number."
        }
    }




}