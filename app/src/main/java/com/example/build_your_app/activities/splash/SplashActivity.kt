package com.example.build_your_app.activities.splash

import SplashScreenViewModel
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.build_your_app.activities.main.MainActivity
import com.example.build_your_app.databinding.ActivitySplashBinding


class SplashActivity : AppCompatActivity() {

    private lateinit var viewModelSplashScreen: SplashScreenViewModel
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        supportActionBar?.hide()
        initViewModel()
        observeSplashLiveData()
    }

    private fun initViewModel() {
        viewModelSplashScreen = ViewModelProvider(this).get(SplashScreenViewModel::class.java)
    }

    private fun observeSplashLiveData() {
        viewModelSplashScreen.initSplashScreen()
        val observer = Observer<Boolean> {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        viewModelSplashScreen.liveData.observe(this, observer)
    }
}