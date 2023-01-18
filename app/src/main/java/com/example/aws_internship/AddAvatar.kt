package com.example.aws_internship

import android.Manifest
import android.R.attr.data
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.aws_internship.databinding.ActivityAddAvatarBinding


class AddAvatar : AppCompatActivity() {

    private lateinit var binding: ActivityAddAvatarBinding
    private lateinit var permissionLauncher: ActivityResultLauncher<Array<String>>
    private var isReadPermissionGranted = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_avatar)

        binding = ActivityAddAvatarBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        permissionLauncher = registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()){ permissions ->

            isReadPermissionGranted = permissions[Manifest.permission.READ_EXTERNAL_STORAGE] ?: isReadPermissionGranted
        }

        requestPermission()

        pickImageGallery()

        binding.ibBackButton.setOnClickListener {
            super.onBackPressed()
        }

        binding.ibRemoveAvatar.setOnClickListener {
            binding.imageView.setImageResource(R.drawable.aws_logo)
            binding.ibRemoveAvatar.isVisible = false
        }

        binding.btnProceed.setOnClickListener{
            val sharedPreferences = getSharedPreferences(MainActivity().preferenceName, 0)
            var editor = sharedPreferences.edit()

            editor.putBoolean("hasLoggedIn",false)
            editor.putBoolean("hasLoggedInHome",true)
            editor.commit()

            val intent = Intent(this@AddAvatar, HomePage::class.java)
            startActivity(intent)
        }

    }

    private fun requestPermission(){
        isReadPermissionGranted = ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ) == PackageManager.PERMISSION_GRANTED

        val permissionRequest : MutableList<String> = ArrayList()

        if (!isReadPermissionGranted){
            permissionRequest.add(Manifest.permission.READ_EXTERNAL_STORAGE)
        }

        if (permissionRequest.isNotEmpty()){
            permissionLauncher.launch(permissionRequest.toTypedArray())
        }
    }

    private fun pickImageGallery() {
        val pickPhoto = registerForActivityResult(
            ActivityResultContracts.GetContent(),
            ActivityResultCallback {
                binding.imageView.setImageURI(it)
            }
        )

        binding.ibAddAvatar.setOnClickListener {
            if (ContextCompat.checkSelfPermission(this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){

                pickPhoto.launch("image/*")

            } else {
                Toast.makeText(this, "Read Permission is not granted", Toast.LENGTH_SHORT).show()
            }
        }
    }
}