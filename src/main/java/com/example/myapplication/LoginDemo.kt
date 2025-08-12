package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.content.Intent
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class LoginDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_login_demo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        var txtUsername = findViewById<EditText>(R.id.txtUsername)
        var txtPassword = findViewById<EditText>(R.id.txtPassword)
        var btnContinue = findViewById<Button>(R.id.btnContinue)
        var btnGuest = findViewById<Button>(R.id.btnGuest)

        btnContinue.setOnClickListener {
            val username = txtUsername.text.toString().trim()
            val password = txtPassword.text.toString()

            when {
                username.isEmpty() -> {
                    showToast("Username cannot be empty")
                }
                password.isEmpty() -> {
                    showToast("Password cannot be empty")
                }
                password.length < 6 -> {
                    showToast("Password must be at least 6 characters")
                }
                else -> {
                    showToast("Login successful!")
                    // Chuyển sang màn hình khác
                    val intent = Intent(this, WelcomeMyApp::class.java)
                    intent.putExtra("username", username)
                    startActivity(intent)
                    //finish() // Đóng màn hình đăng nhập sau khi đăng nhập thành công

                }
            }
        }
        btnGuest.setOnClickListener {
            showToast("Signed in as guest")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}