package com.example.calcvert

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import com.example.calcvert.databinding.ActivitySpeedBinding

class SpeedActivity : AppCompatActivity() {

    val binding by lazy {
        ActivitySpeedBinding.inflate(layoutInflater)
    }

    private val units = arrayOf("Light", "Meter per second", "Kilometer per hour", "Kilometer per second", "Inch per second", "Foot per second")
    private val conversionMatrix = arrayOf(
        // Conversion factors for speed units:
        // Row 0: Light
        // 1.0: Light speed remains constant, so the factor is 1
        // 0.000621371: Conversion from light years to miles
        // 1000.0: Conversion from light years to kilometers
        // 0.001: Conversion from light years to kilometers per second
        // 39.3701: Conversion from light years to inches
        // 3.28084: Conversion from light years to feet
        doubleArrayOf(1.0, 0.000621371, 1000.0, 0.001, 39.3701, 3.28084),
        // Row 1: Meter per second
        // Conversion factors for meters per second to other units
        doubleArrayOf(1609.34, 1.0, 3600.0, 0.001, 39370.1, 3280.84),
        // Row 2: Kilometer per hour
        // Conversion factors for kilometers per hour to other units
        doubleArrayOf(0.001, 0.000277778, 1.0, 0.000001, 0.0393701, 0.00328084),
        // Row 3: Kilometer per second
        // Conversion factors for kilometers per second to other units
        doubleArrayOf(1000.0, 3600.0, 1000000.0, 1.0, 39370000.0, 3280.84),
        // Row 4: Inch per second
        // Conversion factors for inches per second to other units
        doubleArrayOf(0.0254, 0.00064516, 25.4, 0.0000254, 1.0, 0.0833333),
        // Row 5: Foot per second
        // Conversion factors for feet per second to other units
        doubleArrayOf(0.3048, 0.0000846667, 304.8, 0.0003048, 12.0, 1.0)
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, units)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerFromSpeed.adapter = adapter
        binding.spinnerToSpeed.adapter = adapter

        // Set up button click listener
        binding.btnconvertSpeed.setOnClickListener {
            convertUnits()
        }
    }

    private fun convertUnits() {
        val fromUnitIndex = binding.spinnerFromSpeed.selectedItemPosition
        val toUnitIndex = binding.spinnerToSpeed.selectedItemPosition

        if (fromUnitIndex == toUnitIndex) {
            binding.textResultSpeed.text = "Please select different units."
            return
        }

        try {
            val inputValue = binding.editTextValue.text.toString().toDouble()
            val conversionFactor = conversionMatrix[fromUnitIndex][toUnitIndex]
            val result = inputValue * conversionFactor
            binding.textResultSpeed.text = "$inputValue ${units[fromUnitIndex]} is $result ${units[toUnitIndex]}"
        } catch (e: NumberFormatException) {
            binding.textResultSpeed.text = "Invalid input. Please enter a valid number."
        }
    }



}