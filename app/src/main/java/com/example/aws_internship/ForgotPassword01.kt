package com.example.aws_internship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aws_internship.databinding.ActivityForgotPassword01Binding

class ForgotPassword01 : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPassword01Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password01)

        binding = ActivityForgotPassword01Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnProceed.setOnClickListener{
            val intent = Intent(this@ForgotPassword01, ForgotPassword02::class.java)
            startActivity(intent)
            finish()
        }
    }
}