package com.example.myapplication2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : Activity() {
    private lateinit var etUsername: EditText
    private lateinit var etPassword: EditText
    private lateinit var etConfirmPassword: EditText
    private lateinit var btnSignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Connect XML components with Kotlin
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etConfirmPassword = findViewById(R.id.etConfirmPassword)
        btnSignUp = findViewById(R.id.btnSignUp)

        // SIGN UP button
        btnSignUp.setOnClickListener {
            val username = etUsername.text.toString().trim()
            val password = etPassword.text.toString()
            val confirmPassword = etConfirmPassword.text.toString()

            // Check username
            if (username.isEmpty()) {
                Toast.makeText(
                    this,
                    "Please enter username",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // Check password
            if (password.isEmpty()) {
                Toast.makeText(
                    this,
                    "Please enter password",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // Password validation
            if (!isValidPassword(password)) {
                Toast.makeText(
                    this,
                    "Password must contain uppercase, lowercase, number, special character and minimum 8 characters",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            // Confirm password
            if (password != confirmPassword) {
                Toast.makeText(
                    this,
                    "Passwords do not match",
                    Toast.LENGTH_SHORT
                ).show()
                return@setOnClickListener
            }

            // ---------------------------------
            // Create Bundle
            // ---------------------------------
            val bundle = Bundle()
            bundle.putString("USERNAME", username)
            bundle.putString("PASSWORD", password)

            // ---------------------------------
            // Create Intent
            // ---------------------------------
            val intent = Intent(
                this,
                LoginActivity::class.java
            )

            // Attach Bundle to Intent
            intent.putExtras(bundle)

            // Open Login Activity
            startActivity(intent)
        }
    }

    // Password validation function
    private fun isValidPassword(password: String): Boolean {
        // Contains uppercase letter
        val hasUppercase =
            password.any { it.isUpperCase() }

        // Contains lowercase letter
        val hasLowercase =
            password.any { it.isLowerCase() }

        // Contains number
        val hasNumber =
            password.any { it.isDigit() }

        // Contains special character
        val hasSpecialCharacter =
            password.any { !it.isLetterOrDigit() }

        // Minimum length = 8
        val hasMinimumLength =
            password.length >= 8

        return hasUppercase &&
                hasLowercase &&
                hasNumber &&
                hasSpecialCharacter &&
                hasMinimumLength
    }
}
