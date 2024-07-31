package com.example.calcvert

import android.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.calcvert.databinding.ActivitySimpleInterestBinding

class SimpleInterestActivity : AppCompatActivity() {
    val binding by lazy {
        ActivitySimpleInterestBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        val interestTypes = arrayOf("Simple Interest", "Compound Interest")
        val adapter = ArrayAdapter(this, R.layout.simple_spinner_item, interestTypes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.interestTypeSpinner.adapter = adapter

        binding.calculateButton.setOnClickListener {
            calculateInterest()
        }
    }

    private fun calculateInterest() {
        val principalStr = binding.principalEditText.text.toString()
        val rateStr = binding.rateEditText.text.toString()
        val timeStr = binding.timeEditText.text.toString()

        if (principalStr.isEmpty() || rateStr.isEmpty() || timeStr.isEmpty()) {
            Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            return
        }

        val principal = principalStr.toDouble()
        val rate = rateStr.toDouble()
        val time = timeStr.toDouble()

        val selectedInterestType = binding.interestTypeSpinner.selectedItem.toString()

        val interest: Double = when (selectedInterestType) {
            "Simple Interest" -> (principal * rate * time) / 100
            "Compound Interest" -> {
                val amount = principal * Math.pow((1 + rate / 100), time)
                amount - principal
            }
            else -> 0.0
        }

        binding.resultTextView.text = "Interest: $interest"
    }

}