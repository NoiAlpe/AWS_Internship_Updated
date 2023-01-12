package com.example.aws_internship

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import com.example.aws_internship.databinding.ActivityAddAvatarBinding
import com.example.aws_internship.databinding.ActivityEmailOtpBinding
import com.example.aws_internship.databinding.ActivityProfileDetailsBinding

class AddAvatar : AppCompatActivity() {

    private lateinit var binding: ActivityAddAvatarBinding

    companion object {
        val image_request_code = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_avatar)

        binding = ActivityAddAvatarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.ibAddAvatar.setOnClickListener {
            pickImageGallery()
        }

        binding.ibBackButton.setOnClickListener {
            val intent = Intent(this@AddAvatar, ProfileDetails::class.java)
            startActivity(intent)
        }

        binding.ibRemoveAvatar.setOnClickListener {
            binding.imageView.setImageResource(R.drawable.aws_logo)
            binding.ibRemoveAvatar.isVisible = false
        }

        binding.btnProceed.setOnClickListener{
            val intent = Intent(this@AddAvatar, HomePage::class.java)
            startActivity(intent)
        }

    }

    private fun pickImageGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, image_request_code)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == image_request_code && resultCode == RESULT_OK){
            binding.imageView.setImageURI(data?.data)
            binding.ibRemoveAvatar.isVisible = true
        }
    }
}