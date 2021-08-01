package com.example.app_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.app_1.databinding.ActivityLoadingScreenBinding

class ActivityLoadingScreen : AppCompatActivity() {

    private val SPLASH_TIME_OUT : Long = 3000 // 3 sec
    private var progressStatus = 0
    private lateinit var loadingScreen : ActivityLoadingScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        loadingScreen = ActivityLoadingScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading_screen)
        loadingScreen.progressBar.max = 100
        loadingScreen.progressBar.setProgress(100)

        Handler(Looper.getMainLooper()).postDelayed({
            // This method will be executed once the timer is over
            // Start your app main activity
            startActivity(Intent(this, ActivityMainLenta::class.java))

            // close this activity
            finish()
        }, SPLASH_TIME_OUT)
    }
}