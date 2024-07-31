package com.example.calcvert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)


        val splashScreenDuration: Long = 2000 // 3 seconds
        val mainActivityIntent = Intent(this, MainActivity::class.java)

        // Using Handler to delay the startup of MainActivity
        val handler = android.os.Handler()
        handler.postDelayed({
            startActivity(mainActivityIntent)
            finish() // Close the splash screen activity to prevent going back to it
        }, splashScreenDuration)

    }
}