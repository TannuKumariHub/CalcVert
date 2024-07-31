package com.example.calcvert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calcvert.databinding.ActivityConvertPageBinding


class Convert_page : AppCompatActivity() {
    val binding by lazy {
        ActivityConvertPageBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.BmiPgee.setOnClickListener {
            startActivity(Intent(this@Convert_page,BmiActivity::class.java ))
        }


        binding.unitPgee.setOnClickListener {
            startActivity(Intent(this@Convert_page,LengthActivity::class.java))
        }

        binding.agePgee.setOnClickListener {
            startActivity(Intent(this@Convert_page,AgeActivity::class.java))
        }

        binding.setPgee.setOnClickListener {
            startActivity(Intent(this@Convert_page,ArrangeNumberActivity::class.java))
        }
        binding.currencyConverter.setOnClickListener {
            startActivity(Intent(this@Convert_page,CurrencyConverter::class.java))
        }

        binding.MassPage.setOnClickListener {
            startActivity(Intent(this@Convert_page,MassActivity::class.java))
        }

        binding.VolumePage.setOnClickListener {
            startActivity(Intent(this@Convert_page,VolumeActivity::class.java))
        }
        binding.SimpleinterestPage.setOnClickListener {
            startActivity(Intent(this@Convert_page,SimpleInterestActivity::class.java))
        }

        binding.SpeedPage.setOnClickListener {
            startActivity(Intent(this@Convert_page,SpeedActivity::class.java))
        }

        binding.TemperaturePage.setOnClickListener {
            startActivity(Intent(this@Convert_page,TemperatureActivity::class.java))
        }

    }

}