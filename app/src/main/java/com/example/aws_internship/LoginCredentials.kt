package com.example.aws_internship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aws_internship.databinding.ActivityLoginCredentialsBinding

class LoginCredentials : AppCompatActivity() {

    private lateinit var binding: ActivityLoginCredentialsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_credentials)

        binding = ActivityLoginCredentialsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvForgotPassword.setOnClickListener {
            val intent = Intent(this@LoginCredentials, ForgotPassword01::class.java)
            startActivity(intent)
            finish()
        }

        binding.btnLoginContinue.setOnClickListener{

        }

    }
}