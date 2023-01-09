package com.example.aws_internship

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Button
import com.example.aws_internship.databinding.ActivityGetStartedBinding
import com.example.aws_internship.databinding.ActivitySignup01Binding

class GetStarted : AppCompatActivity(){
    @SuppressLint("MissingInflatedId")

    private lateinit var binding: ActivityGetStartedBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_get_started)

        binding = ActivityGetStartedBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnGetStarted.setOnClickListener {
            val intent = Intent(this@GetStarted, Signup01::class.java)
            startActivity(intent)
            finish()
        }

    }


}