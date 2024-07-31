package com.example.calcvert

import android.os.Bundle
import android.widget.DatePicker
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calcvert.databinding.ActivityAgeBinding
import java.util.Calendar

class AgeActivity : AppCompatActivity() {
    private val binding by lazy {
        ActivityAgeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.buttonCalculateAge.setOnClickListener {
            calculateAge(binding.datePicker, binding.textViewAge)
        }
    }

    private fun calculateAge(datePicker: DatePicker, textViewAge: TextView) {
        val selectedDay = datePicker.dayOfMonth
        val selectedMonth = datePicker.month
        val selectedYear = datePicker.year

        val calendar = Calendar.getInstance()
        val currentYear = calendar.get(Calendar.YEAR)
        val currentMonth = calendar.get(Calendar.MONTH)
        val currentDay = calendar.get(Calendar.DAY_OF_MONTH)

        val age = currentYear - selectedYear - if (currentMonth < selectedMonth || (currentMonth == selectedMonth && currentDay < selectedDay)) 1 else 0

        textViewAge.text = getString(R.string.display_age, age)
    }
}
