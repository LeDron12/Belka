package com.example.app_1

import android.animation.ObjectAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.example.app_1.databinding.ActivityLoadingScreenBinding

class ActivityLoadingScreen : AppCompatActivity() {

    private val loadingTime : Long = 3000 // 3 sec
    private lateinit var loadingScreen : ActivityLoadingScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        loadingScreen = ActivityLoadingScreenBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(loadingScreen.root)

        // progressBar animation.
        ObjectAnimator.ofInt(loadingScreen.progressBar, "progress", loadingScreen.progressBar.max)
            .setDuration((loadingTime * 0.9).toLong())
            .start()

        // current activity delay.
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this, ActivityLogInMenu::class.java))
            finish()
        }, loadingTime)
    }
}
