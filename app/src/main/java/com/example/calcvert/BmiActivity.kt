package com.example.calcvert

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.calcvert.databinding.ActivityBmiBinding

class BmiActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityBmiBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.btnCalculate.setOnClickListener {
            if (binding.editWeight.text.toString() != " " && binding.editHeghtfeet.text.toString() != " " && binding.editHeightinch.text.toString() != " "){

                val wt=(binding.editWeight.text.toString()).toDouble()
                val heightfeet=(binding.editHeghtfeet.text.toString()).toDouble()
                val heightinch=(binding.editHeightinch.text.toString()).toDouble()


                val totalInch=(heightfeet*12)+heightinch
                val totalCM=totalInch*2.54
                val totalM=totalCM/100

                val bmi=wt/(totalM*totalM) // formula

                binding.txtTitle.text="Your Bmi"
                binding.txtResult.text ="${bmi.toInt()}"

                if (bmi > 25) {
                    Toast.makeText(this@BmiActivity, R.string.stroverwt, Toast.LENGTH_LONG).show()
                    binding.txtMsg.text = resources.getString(R.string.stroverwt)
                    binding.mainLayout.setBackgroundColor(ContextCompat.getColor(this@BmiActivity, R.color.red))
                } else if (bmi < 18) {
                    Toast.makeText(this@BmiActivity, R.string.strunderwt, Toast.LENGTH_LONG).show()
                    binding.txtMsg.text = resources.getString(R.string.strunderwt)
                    binding.mainLayout.setBackgroundColor(ContextCompat.getColor(this@BmiActivity, R.color.yellow))
                } else {
                    Toast.makeText(this@BmiActivity, R.string.strhealthy, Toast.LENGTH_LONG).show()
                    binding.txtMsg.text = resources.getString(R.string.strhealthy)
                    binding.mainLayout.setBackgroundColor(ContextCompat.getColor(this@BmiActivity, R.color.green))
                }
            }
            else{
                Toast.makeText(this, "oops!😶 Fill First", Toast.LENGTH_LONG).show()
            }
        }
    }
}