package com.example.app_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.app_1.databinding.ActivityLogInMenuBinding

class ActivityLogInMenu : AppCompatActivity() {

    private lateinit var logInScreen : ActivityLogInMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        logInScreen = ActivityLogInMenuBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(logInScreen.root)

        logInScreen.textSignUp.setOnClickListener {
            val signUpOpen = Intent(this, ActivitySignUpMenu::class.java)
            startActivity(signUpOpen)
        }

        logInScreen.buttonLogIn.setOnClickListener {
            val mainLentaOpen = Intent(this, ActivityMainLenta::class.java)
            startActivity(mainLentaOpen)
        }


    }
}