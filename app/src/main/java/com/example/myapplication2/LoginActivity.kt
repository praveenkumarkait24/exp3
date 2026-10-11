package com.example.myapplication2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : Activity() {
    private lateinit var etLoginUsername: EditText
    private lateinit var etLoginPassword: EditText
    private lateinit var btnSignIn: Button

    // Username and password received from Sign Up
    private var savedUsername = ""
    private var savedPassword = ""

    // Number of login attempts
    private var loginAttempts = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Connect XML components
        etLoginUsername =
            findViewById(R.id.etLoginUsername)
        etLoginPassword =
            findViewById(R.id.etLoginPassword)
        btnSignIn =
            findViewById(R.id.btnSignIn)

        // ---------------------------------
        // Receive Bundle from MainActivity
        // ---------------------------------
        val bundle = intent.extras
        if (bundle != null) {
            savedUsername =
                bundle.getString("USERNAME", "") ?: ""
            savedPassword =
                bundle.getString("PASSWORD", "") ?: ""
        }

        // SIGN IN button
        btnSignIn.setOnClickListener {
            val username =
                etLoginUsername.text.toString().trim()
            val password =
                etLoginPassword.text.toString()

            // ---------------------------------
            // Check username and password
            // ---------------------------------
            if (username == savedUsername &&
                password == savedPassword
            ) {
                // Login successful
                val intent = Intent(
                    this,
                    SuccessActivity::class.java
                )
                startActivity(intent)
            } else {
                // Login failed
                loginAttempts++
                if (loginAttempts < 2) {
                    Toast.makeText(
                        this,
                        "Login Failed",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    // Two attempts completed
                    Toast.makeText(
                        this,
                        "Failed Login Attempts",
                        Toast.LENGTH_SHORT
                    ).show()

                    // Disable SIGN IN button
                    btnSignIn.isEnabled = false
                }
            }
        }
    }
}
