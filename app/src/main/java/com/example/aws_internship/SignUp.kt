package com.example.aws_internship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aws_internship.databinding.ActivitySignUpBinding
import com.example.aws_internship.databinding.ActivitySignup01Binding

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnProceed.setOnClickListener {
                val intent = Intent(this@SignUp, EmailOTP::class.java)
                startActivity(intent)
        }

    }
}