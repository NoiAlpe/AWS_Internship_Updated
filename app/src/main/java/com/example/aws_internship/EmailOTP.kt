package com.example.aws_internship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aws_internship.databinding.ActivityEmailOtpBinding
import com.example.aws_internship.databinding.ActivitySignUpBinding

class EmailOTP : AppCompatActivity() {

    private lateinit var binding: ActivityEmailOtpBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_email_otp)

        binding = ActivityEmailOtpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnProceed.setOnClickListener {
            val intent = Intent(this@EmailOTP, ProfileDetails::class.java)
            startActivity(intent)
        }
    }
}