package com.example.app_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.app_1.databinding.ActivitySignUpMenuBinding

class ActivitySignUpMenu : AppCompatActivity() {

    private  lateinit var signUpScreen : ActivitySignUpMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        signUpScreen = ActivitySignUpMenuBinding.inflate(layoutInflater)
        setContentView(signUpScreen.root)
        //signUpScreen.editTextSignUpPhone.text = intent.get("phone")

        signUpScreen.textFinnishButton.setOnClickListener {
            this.finish()
        }
    }
}