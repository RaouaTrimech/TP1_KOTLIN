package com.gl4.tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class WelcomeActivity : AppCompatActivity() {

    lateinit var txtWelcome : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
        txtWelcome = findViewById(R.id.textWelcome)
        txtWelcome.isEnabled = false
        val email = intent.getStringExtra("email")
        txtWelcome.setText("Bienvenue $email")
    }
}