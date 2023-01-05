package com.example.aws_internship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aws_internship.databinding.ActivityEmailOtpBinding
import com.example.aws_internship.databinding.ActivityProfileDetailsBinding

class ProfileDetails : AppCompatActivity() {

    private lateinit var binding: ActivityProfileDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_details)

        binding = ActivityProfileDetailsBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnProceed.setOnClickListener {
            val intent = Intent(this@ProfileDetails, AddAvatar::class.java)
            startActivity(intent)
        }
    }
}