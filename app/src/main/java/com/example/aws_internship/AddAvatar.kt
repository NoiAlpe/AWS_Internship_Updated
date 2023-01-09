package com.example.aws_internship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.aws_internship.databinding.ActivityAddAvatarBinding
import com.example.aws_internship.databinding.ActivityEmailOtpBinding
import com.example.aws_internship.databinding.ActivityProfileDetailsBinding

class AddAvatar : AppCompatActivity() {

    private lateinit var binding: ActivityAddAvatarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_avatar)

        binding = ActivityAddAvatarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.ibBackButton.setOnClickListener {
            val intent = Intent(this@AddAvatar, ProfileDetails::class.java)
            startActivity(intent)
        }

    }
}