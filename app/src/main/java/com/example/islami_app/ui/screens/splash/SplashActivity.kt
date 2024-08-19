package com.example.islami_app.ui.screens.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.islami_app.R
import com.example.islami_app.databinding.ActivitySplashBinding
import com.example.islami_app.ui.screens.home.HomeActivity

class SplashActivity : AppCompatActivity() {

    lateinit var binding :ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        Handler(Looper.getMainLooper()).postDelayed({
            navigateToHome()
        } , 2000)
    }

    private fun navigateToHome() {
        val intent = Intent(this , HomeActivity::class.java)
        startActivity(intent)
    }
}