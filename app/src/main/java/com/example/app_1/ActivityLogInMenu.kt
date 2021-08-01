package com.example.app_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.app_1.databinding.ActivityLogInMenuBinding

class ActivityLogInMenu : AppCompatActivity() {

    private var logInScreen : ActivityLogInMenuBinding = ActivityLogInMenuBinding.inflate(layoutInflater)
    val govno = findViewById<Button>(R.id.buttonLogIn)


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(logInScreen.root)

        logInScreen.textSignUp.setOnClickListener {
            val logInAct = Intent(this, ActivitySignUpMenu::class.java)
            //logInAct.putExtra("phone", logInScreen.editTextLogInPhone.text.toString())
            startActivity(logInAct)
        }

        logInScreen.buttonLogIn.setOnClickListener {
            // LogIn through account.
        }


    }
}